package com.geominfo.model.physical;

/**
 * @author Pu
 * @since 2024/7/11
 */
public class JoinKey {
    /**
     * 源表字段
     */
    private String sourceKey;

    /**
     * 目标表字段
     */
    private String targetKey;

    public JoinKey() {

    }

    public JoinKey(String sourceKey, String targetKey) {
        this.sourceKey = sourceKey;
        this.targetKey = targetKey;
    }

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public String getTargetKey() {
        return targetKey;
    }

    public void setTargetKey(String targetKey) {
        this.targetKey = targetKey;
    }

    @Override
    public String toString() {
        return "JoinKey{" +
                "sourceKey='" + sourceKey + '\'' +
                ", targetKey='" + targetKey + '\'' +
                '}';
    }
}
