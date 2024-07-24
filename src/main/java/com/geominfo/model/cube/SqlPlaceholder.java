package com.geominfo.model.cube;


/**
 * 自定义SQL-动态参数
 * @author Pu
 * @since 2024/7/11
 */
public class SqlPlaceholder {
    /**
     * 唯一标识
     */
    private String uniqueId;

    /**
     * 是否全局应用
     */
    private boolean useInGlobal;

    /**
     * 类型
     */
    private String type;

    /**
     * 变量名
     */
    private String name;

    /**
     * 默认值
     */
    private String defaultValue;

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public boolean isUseInGlobal() {
        return useInGlobal;
    }

    public void setUseInGlobal(boolean useInGlobal) {
        this.useInGlobal = useInGlobal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return "SqlPlaceholder{" +
                "uniqueId='" + uniqueId + '\'' +
                ", useInGlobal=" + useInGlobal +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                '}';
    }
}
