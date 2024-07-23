package com.geominfo.gselect.context;

import com.geominfo.gselect.dialect.DB2Dialect;
import com.geominfo.gselect.dialect.Dialect;
import com.geominfo.gselect.dialect.MySQLDialect;
import com.geominfo.gselect.dialect.OracleDialect;
import com.geominfo.gselect.dialect.PostgreSQLDialect;
import com.geominfo.gselect.dialect.SQLServerDialect;

public enum DialectFactory {

    DB2 {
        @Override
        public Dialect createDialect() {
            return new DB2Dialect();
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
        public Dialect createDialect() {
            return new MySQLDialect();
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
        public Dialect createDialect() {
            return new OracleDialect();
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
        public Dialect createDialect() {
            return new PostgreSQLDialect();
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
        public Dialect createDialect() {
            return new SQLServerDialect();
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
     * Create a {@link Dialect} for the given metadata.
     */
    public abstract Dialect createDialect();

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
