package com.geominfo.model.physical;


import java.util.List;

/**
 * @author Pu
 * @since 2024/7/11
 */
public class Link {

    /**
     * 源表唯一标识
     */
    private String source;

    /**
     * 目标表唯一标识
     */
    private String target;

    /**
     * 连接类型: LEFT_OUTER_JOIN
     */
    private String joinType;

    /**
     * 连接关键字
     */
    private List<JoinKey> joinKeys;

    public Link() {

    }

    public Link(String source, String target, String joinType, List<JoinKey> joinKeys) {
        this.source = source;
        this.target = target;
        this.joinType = joinType;
        this.joinKeys = joinKeys;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public List<JoinKey> getJoinKeys() {
        return joinKeys;
    }

    public void setJoinKeys(List<JoinKey> joinKeys) {
        this.joinKeys = joinKeys;
    }

    @Override
    public String toString() {
        return "Link{" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", joinType='" + joinType + '\'' +
                ", joinKeys=" + joinKeys +
                '}';
    }
}
