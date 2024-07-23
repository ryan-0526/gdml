package com.geominfo.bi;

public class ArgInfo {

    //where/having 条件值类型
    private ValueType valueType;
    //where/having 条件值
    private String value;

    public enum ValueType{
        string,
        number
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
