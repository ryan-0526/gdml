package com.geominfo.model.physical;

import java.util.List;

/**
 * @author Pu
 * @since 2024/7/11
 */
public class VirtualTable {

    private final String uniqueId;
    private final String sql;
    private final String caption;
    private final String datasourceId;
    private final boolean factTable;
    private final String tableName;
    private final List<Field> fields;

    private VirtualTable(Builder builder) {
        this.uniqueId = builder.uniqueId;
        this.sql = builder.sql;
        this.caption = builder.caption;
        this.datasourceId = builder.datasourceId;
        this.factTable = builder.factTable;
        this.tableName = builder.tableName;
        this.fields = builder.fields;
    }

    public static class Builder {
        private String uniqueId;
        private String sql;
        private String caption;
        private String datasourceId;
        private boolean factTable = false; // set default factTable to false
        private String tableName;
        private List<Field> fields;

        public Builder uniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
            return this;
        }

        public Builder sql(String sql) {
            this.sql = sql;
            return this;
        }

        public Builder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public Builder datasourceId(String datasourceId) {
            this.datasourceId = datasourceId;
            return this;
        }

        public Builder factTable(boolean factTable) {
            this.factTable = factTable;
            return this;
        }

        public Builder tableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public Builder fields(List<Field> fields) { // Assuming List<List<Field>> for nested structure
            this.fields = fields;
            return this;
        }

        public VirtualTable build() {
            return new VirtualTable(this);
        }
    }

    // Getters removed for brevity (same as before)


    public String getUniqueId() {
        return uniqueId;
    }

    public String getSql() {
        return sql;
    }

    public String getCaption() {
        return caption;
    }

    public String getDatasourceId() {
        return datasourceId;
    }

    public boolean isFactTable() {
        return factTable;
    }

    public String getTableName() {
        return tableName;
    }

    public List<Field> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "VirtualTable{" +
                "uniqueId='" + uniqueId + '\'' +
                ", sql='" + sql + '\'' +
                ", caption='" + caption + '\'' +
                ", datasourceId='" + datasourceId + '\'' +
                ", factTable=" + factTable +
                ", tableName='" + tableName + '\'' +
                ", fields=" + fields +
                '}';
    }
}
