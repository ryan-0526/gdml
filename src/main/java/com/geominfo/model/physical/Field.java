package com.geominfo.model.physical;

/**
 * @author Pu
 * @since 2024/7/11
 */
public class Field {

    /**
     * 显示名称
     */
    private String caption;

    /**
     * 字段名
     */
    private String column;

    /**
     * 字段类型（数据库中的类型）
     */
    private String columnType;

    /**
     * 数据类型（Java中的类型）
     */
    private String dataType;

    public Field () {

    }

    public Field(String caption, String column, String columnType, String dataType) {
        this.caption = caption;
        this.column = column;
        this.columnType = columnType;
        this.dataType = dataType;
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

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "Field{" +
                "caption='" + caption + '\'' +
                ", column='" + column + '\'' +
                ", columnType='" + columnType + '\'' +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}
