package com.geominfo.bi;

public class QueryConfig {
    private Type type;

    //字段,分页信息配置
    private SqlInfo config;

    //模型id
    private String cubeId;

    public enum Type {
        field,
        paging,
        beforeCondition,
        afterCondition
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public SqlInfo getConfig() {
        return config;
    }

    public void setConfig(SqlInfo config) {
        this.config = config;
    }

    public String getCubeId() {
        return cubeId;
    }

    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }
}