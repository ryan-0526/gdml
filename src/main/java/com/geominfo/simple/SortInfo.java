package com.geominfo.simple;

public class SortInfo {

    private Type sortType;

    private String fid;

    public enum Type{
        desc,
        asc
    }

    public Type getSortType() {
        return sortType;
    }

    public void setSortType(Type sortType) {
        this.sortType = sortType;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }
}
