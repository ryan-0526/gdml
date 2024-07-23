package com.geominfo.bi;

import java.util.List;

public class ThinQuery {
    //图形id
    private String componentId;

    //图形中文名称
    private String componentName;

    //存储字段和分页信息
    private List<QueryConfig> configs;

    //数据类型
    private String dataType = "general";

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public List<QueryConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<QueryConfig> configs) {
        this.configs = configs;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
