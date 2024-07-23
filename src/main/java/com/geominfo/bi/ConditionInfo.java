package com.geominfo.bi;

import java.util.List;

public class ConditionInfo {
    private Operator logicalOperator;
    private List<ConditionInfo> conditions;
    private FieldInfo field;
    private Operator functionalOperator;

    private List<ArgInfo> args;

    public enum Operator{
        and,
        or,
        equalTo,
        in
    }


    public FieldInfo getField() {
        return field;
    }

    public void setField(FieldInfo field) {
        this.field = field;
    }

    public Operator getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(Operator logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    //    public ConditionOperator getLogicalOperator() {
//        return logicalOperator;
//    }
//
//    public void setLogicalOperator(ConditionOperator logicalOperator) {
//        this.logicalOperator = logicalOperator;
//    }

    public List<ConditionInfo> getConditions() {
        return conditions;
    }

    public void setConditions(List<ConditionInfo> conditions) {
        this.conditions = conditions;
    }

    public Operator getFunctionalOperator() {
        return functionalOperator;
    }

    public void setFunctionalOperator(Operator functionalOperator) {
        this.functionalOperator = functionalOperator;
    }

    //    public ConditionOperator getFunctionalOperator() {
//        return functionalOperator;
//    }
//
//    public void setFunctionalOperator(ConditionOperator functionalOperator) {
//        this.functionalOperator = functionalOperator;
//    }

    public List<ArgInfo> getArgs() {
        return args;
    }

    public void setArgs(List<ArgInfo> args) {
        this.args = args;
    }
}
