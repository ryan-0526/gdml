package com.geominfo.gselect.dialect.funcation;

import java.util.concurrent.ConcurrentHashMap;

public class SqlFunctionRegistry {

    private final ConcurrentHashMap<String,String> functions =  new ConcurrentHashMap();
    private String keyName;
    private String valueName;

    public final static String $_KEY = "$_key";
    public final static String $_VALUE = "$_value";


    public SqlFunctionRegistry name(String funcName) {
        this.keyName = funcName;
        return this;
    }

    public SqlFunctionRegistry functionType(FunctionType funcType) {
        switch (funcType) {
            case aggregate:
                aggregatefunctionFill();
                break;
            case transform:
                transformFunctionFill();
                break;
            default:
                break;
        }
        return this;
    }

    public void registry(){
        functions.put(keyName,valueName);
    }

    public void aggregatefunctionFill() {
        StringBuilder func = new StringBuilder();
        func.append(keyName);
        func.append("(");
        func.append($_KEY);
        func.append(")");
        valueName = func.toString();
    }

    public void transformFunctionFill() {
        StringBuilder func = new StringBuilder();
        func.append(keyName);
        func.append("(");
        func.append($_KEY);
        func.append(",");
        func.append($_VALUE);
        func.append(")");
        valueName = func.toString();
    }

    public String getFunction(String keyName,String replaceField) {
        if (functions.containsKey(keyName)) {
            String function = functions.get(keyName);
            return function.replace($_KEY,replaceField);
        }
        return null;
    }


    public String getFunction(String keyName,String replaceField,String replaceFormat) {
        if (functions.containsKey(keyName)) {
            String function = functions.get(keyName);
            return function.replace($_KEY,replaceField).replace($_VALUE,replaceFormat);
        }
        return null;
    }

}
