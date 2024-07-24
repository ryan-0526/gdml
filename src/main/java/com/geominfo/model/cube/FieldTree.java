package com.geominfo.model.cube;


import java.util.List;

/**
 * @author Pu
 * @since 2024/7/11
 */
public class FieldTree {
    /**
     * 唯一标识
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     * attribute、folder、hierarchy
     */
    private String type;

    /**
     * 子节点
     */
    private List<FieldTree> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<FieldTree> getChildren() {
        return children;
    }

    public void setChildren(List<FieldTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "FieldTree{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", children=" + children +
                '}';
    }
}
