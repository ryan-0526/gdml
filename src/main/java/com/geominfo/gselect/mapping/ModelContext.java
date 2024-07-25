package com.geominfo.gselect.mapping;

import com.geominfo.bi.FieldInfo;
import com.geominfo.bi.SqlInfo;
import com.geominfo.bi.ThinQuery;
import com.geominfo.gselect.dialect.DmlDialect;
import com.geominfo.gselect.dialect.funcation.SqlFunctionRegistry;
import com.geominfo.model.Schema;
import com.geominfo.model.cube.Cube;
import com.geominfo.model.cube.Field;
import com.geominfo.model.cube.SqlPlaceholder;
import com.geominfo.model.physical.JoinKey;
import com.geominfo.model.physical.Link;
import com.geominfo.model.physical.PhysicalSchema;
import com.geominfo.model.physical.Table;
import com.geominfo.model.physical.VirtualTable;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

//模型上下文对象
public class ModelContext {

    private SelectModelMapping selectMapping;

    private DmlDialect dialect;

    private ConcurrentHashMap<String,String> tableNameMapping =  new ConcurrentHashMap();

    private ConcurrentHashMap<String, String> tableAsMapping =  new ConcurrentHashMap();

    public ModelContext() {
        this.selectMapping = new SelectModelMapping();
    }

    public void mappingSelect(ThinQuery thinQuery, Schema schema) {
        Cube cube = schema.getCube();
        //字段
        List<Field> modelFields = cube.getFields();
        //自定义sql中自定义参数值
        List<SqlPlaceholder> sqlPlaceholders = cube.getSqlPlaceholders();

        PhysicalSchema physicalSchema = schema.getPhysicalSchema();
        //真实表名
        List<Table> tables = physicalSchema.getTables();
        //表关联关系
        List<Link> links = physicalSchema.getLinks();
        //自定义sql视图表
        List<VirtualTable> virtualTables = physicalSchema.getVirtualTables();

        //获取表id——>真实表名关系
        if (tables != null) {
            tables.forEach(x -> {
                tableNameMapping.put(x.getUniqueId(),x.getName());
                tableAsMapping.put(x.getUniqueId(),as());
            });
        }

        if(virtualTables != null) {
            virtualTables.forEach(x -> {
                tableNameMapping.put(x.getUniqueId(),subQueryTable(x,sqlPlaceholders));
                tableAsMapping.put(x.getUniqueId(),as());
            });
        }

        mappingFrom(links);

        if (thinQuery != null) {
            thinQuery.getConfigs().forEach(x -> {

                switch (x.getType()) {
                    case field:
                        mappingField(x.getConfig(), modelFields);
                        break;
                    case beforeCondition:
                        mappingWhere(x.getConfig(),modelFields);
                }
            });
        }

    }

    private void mappingWhere(SqlInfo config, List<Field> modelFields) {
        StringBuilder whereBuilder = new StringBuilder();
    }

    private void mappingFrom(List<Link> links) {
        StringBuilder fromBuilder = new StringBuilder();
        if(links != null) {
            links.forEach(x -> {
                //源表
                fromBuilder.append(getTableName(x.getSource())).append(" ")
                        .append(getTableAs(x.getSource())).append(" ");

                //join
                fromBuilder.append(joinType(x.getJoinType())).append(" ");

                //目标表
                fromBuilder.append(getTableName(x.getTarget())).append(" ")
                        .append(getTableAs(x.getTarget())).append(" ");

                //join表on条件
                List<JoinKey> joinKeys = x.getJoinKeys();
                if (joinKeys != null) {
                    joinKeys.forEach(y -> {
                        //源表on字段
                        fromBuilder.append(getTableAs(x.getSource())).append(".")
                                .append(y.getSourceKey());

                        //on 条件
                        fromBuilder.append("=");

                        //目标on字段
                        fromBuilder.append(getTableAs(x.getTarget())).append(".")
                                .append(y.getTargetKey()).append(" ");
                    });
                }
            });
        }
        selectMapping.setFromTables(fromBuilder.toString());
    }

    public String joinType(String joinType) {
        switch (joinType) {
            case "inner":
                return "inner join";
            case "left":
                return "left join";
            case "right":
                return "right join";
            case "full":
                return "full join";
            default:
                return "";
        }
    }


    public void mappingField(SqlInfo sqlConfig, List<Field> modelFields) {
        StringBuilder fieldBuilder = new StringBuilder();
        List<FieldInfo> fields = sqlConfig.getFields();

        modelFields.forEach(x -> {
            fields.forEach(y -> {
                if (x.getUniqueId().equals(y.getFid())) {
                    switch (y.getAreaType()) {
                        case row:
                            //维度
                            fieldBuilder.append(fieldRowMapping(y, x));
                            break;
                        case column:
                            //度量
                            fieldBuilder.append(fieldColumnMapping(y, x));
                            break;
                        default:
                            break;
                    }
                }
            });
        });

//        modelFields.stream().map(x -> {
//            fields.stream().map(y -> {
//                if (x.getUniqueId().equals(y.getFid())) {
//                    switch (y.getAreaType()) {
//                        case row:
//                            //维度
//                            fieldBuilder.append(fieldRowMapping(y, x));
//                            break;
//                        case column:
//                            //度量
//                            fieldBuilder.append(fieldColumnMapping(y, x));
//                            break;
//                        default:
//                            break;
//                    }
//                }
//                return y;
//            });
//            return x;
//        });

        //截取最后一个逗号
        selectMapping.setField(fieldBuilder.substring(0,fieldBuilder.length()-1));
    }

    /**
     * 处理维度字段
     * @param sqlConfig 源字段实体
     * @param modelFields 模型字段实体
     * @return  返回最终select拼接 String
     */
    public String fieldRowMapping(FieldInfo sqlConfig, Field modelFields) {
        StringBuilder field = new StringBuilder();
        FieldInfo.DateTrunc dateTrunc = sqlConfig.getDateTrunc();
        if (dateTrunc != null) {
            //日期类型先不做
            switch (dateTrunc) {
                //todo: 需要从具体方言中获取相应的日期函数(先不做)
                case year:
                    break;
                case month:
                    break;
            }
        } else {
            //字符串字段
            field.append(getTableAs(modelFields.getTable())).append(".")
                    .append(modelFields.getCaption())
                    .append(" ")
                    .append(as())
                    .append(",");
        }
        return field.toString();
    }

    /**
     * 处理度量字段
     * @param sqlConfig     源字段实体
     * @param modelFields   模型字段实体
     * @return 返回最终select拼接 String
     */
    public String fieldColumnMapping(FieldInfo sqlConfig, Field modelFields) {
        StringBuilder field = new StringBuilder();
        String aggregate = sqlConfig.getAggregate();
        SqlFunctionRegistry sqlFunctionRegistry = dialect.getSqlFunctionRegistry();

        if (aggregate != null) {
            field.append(getTableAs(modelFields.getTable())).append(".")
                    .append(sqlFunctionRegistry.getFunction(aggregate, modelFields.getCaption()))
                    .append(" ")
                    .append(as())
                    .append(",");
        } else {
            //todo：要获取模型中对度量设置的自定义条件 (模型还没做)
        }

        return field.toString();
    }


    public void queryModel() {

    }

    public void setDialect(DmlDialect dialect) {
        this.dialect = dialect;
    }

    public String as() {
        return "T_" + generateRandomString(3) + "_" + new Random().nextInt(100) + 1;
    }


    public static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // 生成随机字符，可以是大写字母、小写字母或数字
            char c = (char) (random.nextInt(26) + 'A'); // 大写字母
//            if (random.nextBoolean()) { // 随机决定是大写还是小写
//                c += 32; // 转换为小写字母
//            }
            if (random.nextBoolean()) { // 随机决定是字母还是数字
                c = (char) (random.nextInt(10) + '0'); // 数字
            }
            sb.append(c);
        }

        return sb.toString();
    }


    public String subQueryTable(VirtualTable virtualTable, List<SqlPlaceholder> sqlPlaceholders){
        String sql = virtualTable.getSql();
        //替换先简单写，还有好几种格式
        if (sqlPlaceholders != null) {
            for(SqlPlaceholder x: sqlPlaceholders) {
                String fieldParam = "${" + x.getName() + "}";
                String fieldValue = x.getDefaultValue();
                sql = sql.replace(fieldParam,fieldValue);
            }
        }

        StringBuilder table = new StringBuilder();
        return table.append("(")
                .append(sql)
                .append(")")
                .toString();
    }

    public String getTableName(String tableId) {
        return tableNameMapping.get(tableId);
    }

    public String getTableAs(String tableId) {
        return tableAsMapping.get(tableId);
    }
}
