package com.geominfo.model.cube;

import java.util.ArrayList;
import java.util.List;

/**
 * 多维数据结构
 * @author Pu
 * @since 2024/7/11
 */
public class Cube {

    /**
     * cube唯一标识
     */
    private String cubeId;
    /**
     * 显示名称
     */
    private String caption;

    /**
     * 数据集中的树形结构
     */
    private List<FieldTree> fieldTree = new ArrayList<>();

    /**
     * 模型设计的所有字段的集合
     */
    private List<Field> fields = new ArrayList<>();

    /**
     * 自定义SQL，动态参数替换符
     */
    private List<SqlPlaceholder> sqlPlaceholders = new ArrayList<>();

    public String getCubeId() {
        return cubeId;
    }

    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<FieldTree> getFieldTree() {
        return fieldTree;
    }

    public void setFieldTree(List<FieldTree> fieldTree) {
        this.fieldTree = fieldTree;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public List<SqlPlaceholder> getSqlPlaceholders() {
        return sqlPlaceholders;
    }

    public void setSqlPlaceholders(List<SqlPlaceholder> sqlPlaceholders) {
        this.sqlPlaceholders = sqlPlaceholders;
    }

    @Override
    public String toString() {
        return "Cube{" +
                "cubeId='" + cubeId + '\'' +
                ", caption='" + caption + '\'' +
                ", fieldTree=" + fieldTree +
                ", fields=" + fields +
                ", sqlPlaceholders=" + sqlPlaceholders +
                '}';
    }
}
