package com.geominfo.model.cube;

import java.util.List;

/**
 * @author Pu
 * @since 2024/7/11
 */
public class Field {

    /**
     * 字段唯一标识
     */
    private String uniqueId;

    /**
     * 字段显示名称
     */
    private String caption;

    /**
     * 列名
     */
    private String column;

    /**
     * 表的唯一标识
     */
    private String table;

    /**
     * 类型 Dimension、Measure

     */
    private String type;

    /**
     * 是否为计算成员
     */
    boolean isCalculateMember;

    /**
     * 日期格式化串
     */
    private String dataFormat;

    /**
     * 一般集合长度为1，在遇到日期结构时，长度 > 1
     */
    private List<Attribute> attributes;

    public Field() {

    }

    public Field(String uniqueId, String caption, String column, String table, String type, boolean isCalculateMember, String dataFormat, List<Attribute> attributes) {
        this.uniqueId = uniqueId;
        this.caption = caption;
        this.column = column;
        this.table = table;
        this.type = type;
        this.isCalculateMember = isCalculateMember;
        this.dataFormat = dataFormat;
        this.attributes = attributes;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCalculateMember() {
        return isCalculateMember;
    }

    public void setCalculateMember(boolean calculateMember) {
        isCalculateMember = calculateMember;
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Field{" +
                "uniqueId='" + uniqueId + '\'' +
                ", caption='" + caption + '\'' +
                ", column='" + column + '\'' +
                ", table='" + table + '\'' +
                ", type='" + type + '\'' +
                ", isCalculateMember=" + isCalculateMember +
                ", dataFormat='" + dataFormat + '\'' +
                ", attributes=" + attributes +
                '}';
    }
}
