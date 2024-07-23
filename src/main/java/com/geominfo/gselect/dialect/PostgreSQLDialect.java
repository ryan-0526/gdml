package com.geominfo.gselect.dialect;

public class PostgreSQLDialect extends Dialect {


    @Override
    public String getPagingSql() {
        return "select $BODY limit $PAGESIZE offset $SKIP_ROWS ";
    }

}
