package com.geominfo.model;

/**
 * @author Pu
 * @since 2024/7/19
 */

public class DataSource {

    private Long id;

    private String schema;

    private String databaseName;

    private String ip;

    private Integer port;

    private String driver;

    private String type;

    public DataSource() {
    }

    public DataSource(Long id, String schema, String databaseName, String ip, Integer port, String driver, String type) {
        this.id = id;
        this.schema = schema;
        this.databaseName = databaseName;
        this.ip = ip;
        this.port = port;
        this.driver = driver;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "id=" + id +
                ", schema='" + schema + '\'' +
                ", databaseName='" + databaseName + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", driver='" + driver + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}