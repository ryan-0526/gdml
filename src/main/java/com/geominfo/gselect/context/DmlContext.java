package com.geominfo.gselect.context;

import com.geominfo.bi.ThinQuery;
import com.geominfo.gselect.dialect.DmlDialect;
import com.geominfo.gselect.mapping.ModelContext;
import com.geominfo.gselect.util.SelectGenerate;
import com.geominfo.model.Schema;

public class DmlContext {

    private DialectType dialectType;

    private ModelContext modelContext;

//    public DmlContext(DialectType dialectType) {
//        this.dialectType = dialectType;
//        this.modelContext = new ModelContext();
//    }

    public DmlContext() {
        this.modelContext = new ModelContext();
    }


    /**
     * 后续完善
     * @param thinQuery 源实体对象
     * @return DmlContext
     */
    public DmlContext build(ThinQuery thinQuery) {
        //todo: 1.首先获取根据cubeId获取模型对象实体

        //todo: 2.根据模型对象，获取当前数据库类型(oracle,mysql...)

        //todo：3.根据数据库类型获取对应方言

        //todo: 4.根据模型实体和ThinQuery映射，抽取select真实拼接信息对象
        modelContext.mappingSelect(thinQuery,new Schema());

        //todo: 5.创建SelectGenerate对象(工具类，打算开始拼接select)
        return this;
    }

    /**
     * 目前没有从数据库查模型，所以构建一个外部传入模型方法
     * @param thinQuery 源实体对象
     * @param schema 模型实体对象
     * @return DmlContext
     */
    public DmlContext build(ThinQuery thinQuery, Schema schema) {
        //1.根据模型对象，获取当前数据库类型(oracle,mysql...)

        //2.根据数据库类型获取对应方言
        StandardDmlDialectResolver dialectResolver = new StandardDmlDialectResolver();
        DmlDialect dmlDialect = dialectResolver.resolveDialect(DialectType.ORACLE);

        //3. 根据模型实体和ThinQuery映射，抽取select真实拼接信息对象
        modelContext.setDialect(dmlDialect);
        modelContext.mappingSelect(thinQuery, schema);

        //todo: 4.创建SelectGenerate对象(工具类，打算开始拼接select)
        return this;
    }

    public String getSelectSql() {
        //todo:使用工具类生成 select
        SelectGenerate selectGenerate = new SelectGenerate();

        return null;
    }

}
