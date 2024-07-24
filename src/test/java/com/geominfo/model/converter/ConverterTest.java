package com.geominfo.model.converter;

import com.alibaba.fastjson.JSONObject;
import com.geominfo.model.DataSource;
import com.geominfo.model.Schema;
import com.geominfo.model.cube.Cube;
import com.geominfo.model.physical.PhysicalSchema;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.sql.*;

/**
 * @author Pu
 * @since 2024/7/24
 */
public class ConverterTest {
    public static void main(String[] args) {
        loadSchema();

    }

    @SuppressWarnings("all")
    private static void loadSchema() {
        Connection connection = null;
        Statement statement = null;
        Statement nestedStatement = null;
        ResultSet resultSet = null;
        ResultSet nestedResultSet = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://192.168.0.219:5432/edw", "gpadmin", "gpadmin123");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM t_system_resources WHERE ID = 505170");
            if (resultSet.next()) {
                String contentInfo = resultSet.getString("content_info");
                JSONObject contentObject = JSONObject.parseObject(contentInfo);


                DataSource dataSource = null;
                String datasourcesId = contentObject.getString("datasources");

                nestedStatement = connection.createStatement();
                nestedResultSet = nestedStatement.executeQuery("SELECT * FROM t_system_resources WHERE ID = " + datasourcesId);
                if (nestedResultSet.next()) {
                    // 处理嵌套查询的结果
                    String nestedContentInfo = nestedResultSet.getString("content_info");
                    JSONObject databaseObj = JSONObject.parseObject(nestedContentInfo);

                    dataSource = new DataSource(
                            nestedResultSet.getLong("id"),
                            databaseObj.getString("schema"),
                            databaseObj.getString("connectionName"),
                            databaseObj.getString("address"),
                            databaseObj.getInteger("port"),
                            databaseObj.getString("driver")
                    );
                }


                String xmlStr = contentObject.getString("data");
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = null;
                builder = factory.newDocumentBuilder();
                Document document = builder.parse(new InputSource(new StringReader(xmlStr)));
                System.out.println(xmlStr);
                System.out.println("######################转换#####################");

                PhysicalSchema physicalSchema = new PhysicalSchemaConverter(document, dataSource).convert();
                Cube cube = new CubeConverter(document).convert();
                Schema schema = new Schema(physicalSchema, cube, null);
                System.out.println(JSONObject.toJSONString(schema));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                if (nestedStatement != null && !nestedStatement.isClosed()) {
                    nestedStatement.close();
                }
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
                if (nestedResultSet != null && !nestedResultSet.isClosed()) {
                    nestedResultSet.close();
                }
            }catch (Exception ignore) {

            }
        }
    }

}
