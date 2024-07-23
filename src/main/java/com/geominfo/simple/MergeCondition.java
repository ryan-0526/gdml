package com.geominfo.simple;

import com.geominfo.bi.ArgInfo;
import com.geominfo.bi.FieldInfo;

import java.util.List;

public class MergeCondition {

    private FieldInfo field;

    private ConditionOperator functionalOperator;

    private List<ArgInfo> args;


    public FieldInfo getField() {
        return field;
    }

    public void setField(FieldInfo field) {
        this.field = field;
    }

    public ConditionOperator getFunctionalOperator() {
        return functionalOperator;
    }

    public void setFunctionalOperator(ConditionOperator functionalOperator) {
        this.functionalOperator = functionalOperator;
    }

    public List<ArgInfo> getArgs() {
        return args;
    }

    public void setArgs(List<ArgInfo> args) {
        this.args = args;
    }
}
