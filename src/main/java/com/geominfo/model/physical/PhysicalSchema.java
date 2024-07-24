package com.geominfo.model.physical;

import java.util.ArrayList;
import java.util.List;

/**
 * 物理模式
 * 在 OLAP 模型中定义的实际数据库表和列的结构，这些表和列被用来建立多维数据集（cube）的基础
 * @author Pu
 * @since 2024/7/11
 */
public class PhysicalSchema {

    /**
     * 事实表/维表集合
     */
    private List<Table> tables = new ArrayList<>();

    /**
     * 自定义SQL创建表的集合
     */
    private List<VirtualTable> virtualTables = new ArrayList<>();

    /**
     * 表的关联关系集合
     */
    private List<Link> links = new ArrayList<>();

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<VirtualTable> getVirtualTables() {
        return virtualTables;
    }

    public void setVirtualTables(List<VirtualTable> virtualTables) {
        this.virtualTables = virtualTables;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "PhysicalSchema{" +
                "tables=" + tables +
                ", virtualTables=" + virtualTables +
                ", links=" + links +
                '}';
    }
}
