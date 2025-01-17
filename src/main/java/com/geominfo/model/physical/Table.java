package com.geominfo.model.physical;

/**
 * @author Pu
 * @since 2024/7/11
 */
public class Table {

    private  String uniqueId;
    private  String schema;
    private  String name;
    private  String caption;
    private  String datasourceId;
    private  boolean factTable;
    private  String dsType;

    public Table() {

    }

    private Table(Builder builder) {
        this.uniqueId = builder.uniqueId;
        this.schema = builder.schema;
        this.name = builder.name;
        this.caption = builder.caption;
        this.datasourceId = builder.datasourceId;
        this.factTable = builder.factTable;
        this.dsType = builder.dsType;
    }

    public static class Builder {
        private String uniqueId;
        private String schema;
        private String name;
        private String caption;
        private String datasourceId;
        private boolean factTable = false; // Set default factTable to false

        private String dsType;

        public String getUniqueId() {
            return uniqueId;
        }

        public String getSchema() {
            return schema;
        }

        public String getName() {
            return name;
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

        public String getDsType() {
            return dsType;
        }

        public Builder uniqueId(String uniqueId) {
            this.uniqueId = uniqueId;
            return this;
        }

        public Builder schema(String schema) {
            this.schema = schema;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
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

        public Builder dsType(String dsType) {
            this.dsType = dsType;
            return this;
        }

        public Table build() {
            return new Table(this);
        }
    }

    // Getters removed for brevity (same as before)

    public String getUniqueId() {
        return uniqueId;
    }

    public String getSchema() {
        return schema;
    }

    public String getName() {
        return name;
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

    public String getDsType() {
        return dsType;
    }

    @Override
    public String toString() {
        return "Table{" +
                "uniqueId='" + uniqueId + '\'' +
                ", schema='" + schema + '\'' +
                ", name='" + name + '\'' +
                ", caption='" + caption + '\'' +
                ", datasourceId='" + datasourceId + '\'' +
                ", factTable=" + factTable +
                ", dsType='" + dsType + '\'' +
                '}';
    }
}
