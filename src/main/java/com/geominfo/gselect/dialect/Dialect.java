package com.geominfo.gselect.dialect;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


public abstract class Dialect {

    private final Set<String> functions = new HashSet<>();


    protected void registerFunctions() {

    }

    /**
     * 从数据库去查
     */
    protected void registerFunctions(DatabaseMetaData info) {
        try {
            //hibernate 源码
            //ResultSet sqlFunction = info.getDatabaseMetadata().getFunctions(null, null, "%");
            ResultSet sqlFunction = info.getFunctions(null, null, "%");
            while (sqlFunction.next()) {
                functions.add(sqlFunction.getString("FUNCTION_NAME").toLowerCase());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<String> getFunctions() {
        return functions;
    }

    public String startSelectSql() {
        return "select * from (";
    }

    public String endSelectSql() {
        return ")";
    }

    public String getPagingSql() {
        return null;
    }

    public String getSelectString() {
        return "select ";
    }

    public String getFromString() {
        return "from ";
    }

    public String getWhereString() {
        return "where ";
    }

    public String getGroupByString() {
        return "group by ";
    }

    public String getHavingString() {
        return "having ";
    }


}
