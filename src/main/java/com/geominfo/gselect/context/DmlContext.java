package com.geominfo.gselect.context;

import com.geominfo.bi.ThinQuery;
import com.geominfo.gselect.mapping.ModelContext;

public class DmlContext {

    private DialectType dialectType;

    private ModelContext modelContext;

//    public DmlContext(DialectType dialectType) {
//        this.dialectType = dialectType;
//        this.modelContext = new ModelContext();
//    }

    public DmlContext() {
        this.modelContext = new ModelContext();
    }


    public DmlContext build(ThinQuery thinQuery) {
        //todo: 1.首先获取根据cubeId获取模型对象实体

        //todo: 2.根据模型对象，获取当前数据库类型(oracle,mysql...)

        //todo：3.根据数据库类型获取对应方言

        //todo: 4.根据模型实体和ThinQuery映射，抽取select真实拼接信息对象
        modelContext.mappingSelect(thinQuery/*,模型实体*/);

        //todo: 5.创建SelectGenerate对象(工具类，打算开始拼接select)
        return this;
    }

    public String getSelectSql() {
        //todo:使用工具类生成 select
        return null;
    }

}
