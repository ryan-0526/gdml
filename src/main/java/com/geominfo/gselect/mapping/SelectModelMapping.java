package com.geominfo.gselect.mapping;

import com.geominfo.gselect.dialect.DmlDialect;

import java.util.List;

//根据ThinQuery与模型实体映射信息存储
public class SelectModelMapping {

//    private DmlDialect dialect;
//
//    private List<String> fieldNames;
//
//    private List<String> fromTables;
//
//    private List<String> whereCondition;

    private String field;

    private String fromTables;

    private String whereConditions;

    private String groupBy;

    private String havings;

    private String sort;

    private String paging;


    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFromTables() {
        return fromTables;
    }

    public void setFromTables(String fromTables) {
        this.fromTables = fromTables;
    }

    public String getWhereConditions() {
        return whereConditions;
    }

    public void setWhereConditions(String whereConditions) {
        this.whereConditions = whereConditions;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getHavings() {
        return havings;
    }

    public void setHavings(String havings) {
        this.havings = havings;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPaging() {
        return paging;
    }

    public void setPaging(String paging) {
        this.paging = paging;
    }
}
