package com.geominfo.gselect.dialect.funcation;

public class BaseFunctionFactory {

    private SqlFunctionRegistry functionRegistry;

    public BaseFunctionFactory() {
        this.functionRegistry = new SqlFunctionRegistry();
    }

    public void aggregates() {
        functionRegistry.name("max")
                .functionType(FunctionType.aggregate)
                .registry();

        functionRegistry.name("min")
                .functionType(FunctionType.aggregate)
                .registry();

        functionRegistry.name("sum")
                .functionType(FunctionType.aggregate)
                .registry();

        functionRegistry.name("avg")
                .functionType(FunctionType.aggregate)
                .registry();

        functionRegistry.name("count")
                .functionType(FunctionType.aggregate)
                .registry();
    }

    public SqlFunctionRegistry getFunctionRegistry() {
        return functionRegistry;
    }
}
