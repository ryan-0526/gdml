package com.geominfo.gselect.util;


//拼接select语句工具类
import com.geominfo.gselect.dialect.DmlDialect;

public class SelectGenerate {

    private DmlDialect dialect;

    public String buildSelectString() {
        StringBuilder selectSql = new StringBuilder();
        //开始sql,准备嵌套子查询
        selectSql.append(dialect.startSelectSql());
        selectSql.append(dialect.getSelectString());
        selectSql.append(""/*字段信息*/);
        selectSql.append(dialect.getFromString());
        //判断是否有json
        selectSql.append("...");
        //
        return null;
    }

}
