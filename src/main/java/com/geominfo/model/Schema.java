package com.geominfo.model;

import com.geominfo.model.cube.Cube;
import com.geominfo.model.extra.ExtraInfo;
import com.geominfo.model.physical.PhysicalSchema;

/**
 * 多维模型的定义
 * @author Pu
 * @since 2024/7/11
 */
public class Schema {

    /**
     * 物理模式
     */
    private PhysicalSchema physicalSchema;

    /**
     * 多维数据结构
     */
    private Cube cube;

    /**
     * 模型额外信息记录
     */
    private ExtraInfo extraInfo;

    public Schema() {

    }

    public Schema(PhysicalSchema physicalSchema, Cube cube, ExtraInfo extraInfo) {
        this.physicalSchema = physicalSchema;
        this.cube = cube;
        this.extraInfo = extraInfo;
    }

    public PhysicalSchema getPhysicalSchema() {
        return physicalSchema;
    }

    public void setPhysicalSchema(PhysicalSchema physicalSchema) {
        this.physicalSchema = physicalSchema;
    }

    public Cube getCube() {
        return cube;
    }

    public void setCube(Cube cube) {
        this.cube = cube;
    }

    public ExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }

    @Override
    public String toString() {
        return "Schema{" +
                "physicalSchema=" + physicalSchema +
                ", cube=" + cube +
                ", extraInfo=" + extraInfo +
                '}';
    }
}
