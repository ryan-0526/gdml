package com.geominfo.gselect.context;

import com.geominfo.gselect.dialect.DmlDB2Dialect;
import com.geominfo.gselect.dialect.DmlDialect;
import com.geominfo.gselect.dialect.DmlMySQLDialect;
import com.geominfo.gselect.dialect.DmlOracleDialect;
import com.geominfo.gselect.dialect.DmlPostgreSQLDialect;
import com.geominfo.gselect.dialect.DmlSQLServerDialect;

public enum DialectFactory {

    DB2 {
        @Override
        public DmlDialect createDialect() {
            return new DmlDB2Dialect();
        }
        @Override
        public boolean productNameMatches(String databaseName) {
            return databaseName.startsWith( "db2" );
        }
        @Override
        public String getDriverClassName(String jdbcUrl) {
            return "com.ibm.db2.jcc.DB2Driver";
        }
    },


    MYSQL {
        @Override
        public DmlDialect createDialect() {
            return new DmlMySQLDialect();
        }
        @Override
        public boolean productNameMatches(String databaseName) {
            return "mysql".equals( databaseName );
        }
        @Override
        public String getDriverClassName(String jdbcUrl) {
            return "com.mysql.cj.jdbc.Driver";
        }
    },

    ORACLE {
        @Override
        public DmlDialect createDialect() {
            return new DmlOracleDialect();
        }
        @Override
        public boolean productNameMatches(String databaseName) {
            return "oracle".equals( databaseName );
        }
		@Override
		public String getDriverClassName(String jdbcUrl) {
			return "oracle.jdbc.OracleDriver";
		}
    },

    POSTGRESQL {
        @Override
        public DmlDialect createDialect() {
            return new DmlPostgreSQLDialect();
        }
        @Override
        public boolean productNameMatches(String databaseName) {
            return "postgresql".equals( databaseName );
        }
        @Override
        public String getDriverClassName(String jdbcUrl) {
            return "org.postgresql.Driver";
        }
    },


    SQLSERVER {
        @Override
        public DmlDialect createDialect() {
            return new DmlSQLServerDialect();
        }
        @Override
        public boolean productNameMatches(String databaseName) {
            return databaseName.startsWith( "sqlserver" );
        }
        @Override
        public String getDriverClassName(String jdbcUrl) {
            return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        }
    };

    public boolean matchesResolutionInfo(DialectType dialectType) {
        return productNameMatches( dialectType.getName() );
    }

    /**
     * Does this database have the given product name?
     */
    public abstract boolean productNameMatches(String productName);

    /**
     * Create a {@link DmlDialect} for the given metadata.
     */
    public abstract DmlDialect createDialect();

    /**
     * Get the name of the JDBC driver class for this database,
     * or null if we're not too sure what it should be.
     */
    public String getDriverClassName(String jdbcUrl) {
        return null;
    }

    /**
     * Get the JDBC URL prefix used by this database.
     */
    public String getUrlPrefix() {
        return "jdbc:" + toString().toLowerCase() + ":";
    }

    /**
     * Does the given JDBC URL connect to this database?
     */
    public boolean matchesUrl(String jdbcUrl) {
        return jdbcUrl.toLowerCase().startsWith( getUrlPrefix() );
    }

}
