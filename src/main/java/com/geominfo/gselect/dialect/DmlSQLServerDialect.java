package com.geominfo.gselect.dialect;

import com.geominfo.gselect.dialect.funcation.SqlFunctionRegistry;

public class DmlSQLServerDialect extends DmlDialect {

    public DmlSQLServerDialect() {
        initFunctionRegistry();
    }

    @Override
    public void initFunctionRegistry() {
        super.initFunctionRegistry();
        SqlFunctionRegistry functionRegistry = baseFunctionFactory.getFunctionRegistry();
        //todo:注册独属于oracle的函数
    }

}