package com.geominfo.gselect;

import com.geominfo.bi.ThinQuery;
import com.geominfo.gselect.context.DmlContext;

public class DmlContextTest {

    public static void main(String[] args) {
        ThinQuery thinQuery = JsonTest.getThinQuery();

        //数据库类型在 ThinQuery对象根据 cubeId 查询模型后能获取到，所以这里不用显示制定了，不然使用者也不知道 (废弃)
//        DmlContext dmlContext = new DmlContext(DialectType.ORACLE);
        String selectSql = new DmlContext()
                .build(thinQuery)
                .getSelectSql();
    }
}
