package com.geominfo.bi;

import java.util.List;

public class SqlInfo {
    //字段信息
    private List<FieldInfo> fields;

    //页码展示数量
    private int limit;

    //页码
    private int offset;

    private ConditionInfo.Operator logicalOperator;
    private List<ConditionInfo> conditions;

    public List<FieldInfo> getFields() {
        return fields;
    }

    public void setFields(List<FieldInfo> fields) {
        this.fields = fields;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public ConditionInfo.Operator getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(ConditionInfo.Operator logicalOperator) {
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
}
