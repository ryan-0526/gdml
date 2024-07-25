package com.geominfo.gselect.dialect;

import com.geominfo.gselect.dialect.funcation.SqlFunctionRegistry;

public class DmlOracleDialect extends DmlDialect {


    @Override
    protected void initFunctionRegistry() {
        super.initFunctionRegistry();
        SqlFunctionRegistry functionRegistry = baseFunctionFactory.getFunctionRegistry();
        //todo:注册独属于oracle的函数
    }

    public DmlOracleDialect() {
        initFunctionRegistry();
    }

}
