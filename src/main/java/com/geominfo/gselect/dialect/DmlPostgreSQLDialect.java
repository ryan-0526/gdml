package com.geominfo.gselect.dialect;

import com.geominfo.gselect.dialect.funcation.SqlFunctionRegistry;

public class DmlPostgreSQLDialect extends DmlDialect {


    public DmlPostgreSQLDialect() {
        initFunctionRegistry();
    }

    @Override
    public void initFunctionRegistry() {
        super.initFunctionRegistry();
        SqlFunctionRegistry functionRegistry = baseFunctionFactory.getFunctionRegistry();
        //todo:注册独属于oracle的函数
    }

    @Override
    public String getPagingSql() {
        return "select $BODY limit $PAGESIZE offset $SKIP_ROWS ";
    }

}
