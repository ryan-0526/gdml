package com.geominfo.model.extra;


import java.time.LocalDateTime;
import java.util.List;

/**
 * 保存模型的行/列权限信息
 * @author Pu
 * @since 2024/7/11
 */
public class ExtraInfo {

    /**
     * 是否开启行级权限
     */
    private boolean rowLevelPermissionEnabled;

    /**
     * 是否开启列级权限
     */
    private boolean columnLevelPermissionEnabled;

    /**
     * 权限模型唯一标识集合
     */
    private List<String> dataAttributeIds;

    /**
     * 最后一次修改时间
     */
    private LocalDateTime lastModified;

    public boolean isRowLevelPermissionEnabled() {
        return rowLevelPermissionEnabled;
    }

    public void setRowLevelPermissionEnabled(boolean rowLevelPermissionEnabled) {
        this.rowLevelPermissionEnabled = rowLevelPermissionEnabled;
    }

    public boolean isColumnLevelPermissionEnabled() {
        return columnLevelPermissionEnabled;
    }

    public void setColumnLevelPermissionEnabled(boolean columnLevelPermissionEnabled) {
        this.columnLevelPermissionEnabled = columnLevelPermissionEnabled;
    }

    public List<String> getDataAttributeIds() {
        return dataAttributeIds;
    }

    public void setDataAttributeIds(List<String> dataAttributeIds) {
        this.dataAttributeIds = dataAttributeIds;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "ExtraInfo{" +
                "rowLevelPermissionEnabled=" + rowLevelPermissionEnabled +
                ", columnLevelPermissionEnabled=" + columnLevelPermissionEnabled +
                ", dataAttributeIds=" + dataAttributeIds +
                ", lastModified=" + lastModified +
                '}';
    }
}
