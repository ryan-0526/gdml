package com.geominfo.model.converter;

import com.geominfo.model.DataSource;
import com.geominfo.model.physical.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.*;
import java.util.*;

/**
 * @author Pu
 * @since 2024/7/18
 */
public class PhysicalSchemaConverter {

    private final Document document;

    private final DataSource dataSource;

    private final PhysicalSchema physicalSchema = new PhysicalSchema();


    private static final XPath xPath = XPathFactory.newInstance().newXPath();

    public PhysicalSchemaConverter (Document document, DataSource dataSource) {
        this.document = document;
        this.dataSource = dataSource;

    }


    public PhysicalSchema convert() throws XPathExpressionException {
        PhysicalSchemaConverter converter = this.convertTables()
                .convertVirtualTables()
                .convertLinks();
        return converter.physicalSchema;
    }

    private PhysicalSchemaConverter convertTables() throws XPathExpressionException {
        List<String> factTableNames = loadFactTableNames(document);

        XPathExpression xPathExpression = xPath.compile("//PhysicalSchema/Table");
        NodeList tableNodes = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < tableNodes.getLength(); i++) {
            Element tableElement = (Element) tableNodes.item(i);
            String tableName = tableElement.getAttribute("name");
            boolean isFact =
                    factTableNames.contains(tableElement.getAttribute("alias")) || factTableNames.contains("tableName");
            Table table = new Table.Builder()
                    .uniqueId(UUID.randomUUID().toString())
                    .schema(dataSource.getSchema())
                    .name(tableName)
                    .caption(tableElement.getAttribute("caption"))
                    .datasourceId(dataSource.getId().toString())
                    .factTable(isFact)
                    .dsType(dataSource.getType())
                    .build();

            physicalSchema.getTables().add(table);
        }
        return this;
    }


    private PhysicalSchemaConverter convertVirtualTables() throws XPathExpressionException {
        Node sqlNode = (Node) xPath.compile("//PhysicalSchema/Query/ExpressionView/SQL")
                .evaluate(document, XPathConstants.NODE);

        if (sqlNode != null) {
            // 获取 <SQL> 元素的文本内容
            String sql = sqlNode.getTextContent();

            // 去掉 CDATA 包装
            sql = sql.trim();
            if (sql.startsWith("<![CDATA[")) {
                sql = sql.substring(9); // 去掉 "<![CDATA[" 部分
                int endIndex = sql.indexOf("]]>");
                if (endIndex != -1) {
                    sql = sql.substring(0, endIndex); // 去掉 "]]>" 部分
                }
            }

            XPathExpression xPathExpression = xPath.compile("//PhysicalSchema/Query");
            Element queryElement  = (Element) xPathExpression.evaluate(document, XPathConstants.NODE);

            List<String> factTableNames = loadFactTableNames(document);
            boolean isFact = factTableNames.contains(queryElement.getAttribute("alias"));

            List<Field> fields = new ArrayList<>();

            if (isFact) {
                NodeList measureNodes  = (NodeList) xPath.compile("//Measures/Measure")
                        .evaluate(document, XPathConstants.NODESET);

                for (int i = 0 ; i < measureNodes.getLength(); i++) {
                    Element measureElement = (Element)measureNodes.item(i);
                    Field field = new Field(
                            measureElement.getAttribute("caption"),
                            measureElement.getAttribute("column"),
                            null,
                            measureElement.getAttribute("datatype")
                    );

                    fields.add(field);
                }
            }

            VirtualTable virtualTable = new VirtualTable.Builder()
                    .uniqueId(UUID.randomUUID().toString())
                    .tableName("TS" + System.currentTimeMillis())
                    .caption(queryElement.getAttribute("caption"))
                    .sql(sql)
                    .datasourceId(dataSource.getId().toString())
                    .factTable(isFact)
                    .fields(fields)
                    .dsType(dataSource.getType())
                    .build();

            physicalSchema.getVirtualTables().add(virtualTable);
        }
        return this;
    }


    private PhysicalSchemaConverter convertLinks() throws XPathExpressionException {

        NodeList linkNodes = (NodeList) xPath.compile("//PhysicalSchema/Link")
                .evaluate(document, XPathConstants.NODESET);

        XPathExpression xPathExpression = xPath.compile("//PhysicalSchema/Table");
        NodeList tableNodes = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < linkNodes.getLength(); i++) {
            Element linkElement = (Element) linkNodes.item(i);
            Element foreignKeyElement = (Element)linkElement.getElementsByTagName("ForeignKey").item(0);
            Element columnElement = (Element)foreignKeyElement.getElementsByTagName("Column").item(0);

            String factTableName = linkElement.getAttribute("target");
            String dimTableAlias= linkElement.getAttribute("source");

            NodeList dimNodes = (NodeList) xPath.compile("//Dimensions/Dimension")
                    .evaluate(document, XPathConstants.NODESET);
            String dimKey = null;
            for (int j = 0; j < dimNodes.getLength(); j++) {
                Element dimElement = (Element)dimNodes.item(j);
                if (!dimTableAlias.equals(dimElement.getAttribute("name"))) {
                    continue;
                }
                dimKey = dimElement.getAttribute("key");
                break;
            }
            JoinKey joinKey = new JoinKey(columnElement.getAttribute("name"), dimKey);

            String sourceId = null;

            Optional<Table> factTableOpt = physicalSchema.getTables()
                    .stream()
                    .filter(
                            table -> factTableName.equals(table.getName())
                    )
                    .findAny();
            if (!factTableOpt.isPresent()) {
                Optional<VirtualTable> virtualTableOpt = physicalSchema.getVirtualTables().stream()
                        .filter(
                                table -> factTableName.equals(table.getCaption())
                        )
                        .findAny();
                if (!virtualTableOpt.isPresent()) {
                    throw new RuntimeException("Not found fact table named " + factTableName);
                }else {
                    sourceId = virtualTableOpt.get().getUniqueId();
                }
            }else {
                sourceId = factTableOpt.get().getUniqueId();
            }

            String targetId = null;
            String joinType = null;
            for(int j = 0 ; j < tableNodes.getLength(); j++) {
                Element tableElement = (Element)tableNodes.item(j);
                if (dimTableAlias.equals(tableElement.getAttribute("alias"))) {
                    joinType = tableElement.getAttribute("joinsType");

                    Optional<Table> dimTableOpt = physicalSchema.getTables()
                            .stream()
                            .filter(
                                    table -> table.getName().equals(tableElement.getAttribute("name"))
                            )
                            .findAny();
                    if (!dimTableOpt.isPresent()) {
                        throw new RuntimeException("Not found dimension table named " + tableElement.getAttribute("name"));
                    }else {
                        targetId = dimTableOpt.get().getUniqueId();
                    }

                }
            }

            Link link = new Link(
                    sourceId,
                    targetId,
                    joinType,
                    Collections.singletonList(joinKey));

            physicalSchema.getLinks().add(link);
        }

        return this;
    }


    private List<String> loadFactTableNames(Document document) throws XPathExpressionException {
        List<String> factTableNames = new ArrayList<>();

        XPathExpression xPathExpression = xPath.compile("//Measures/Measure");
        NodeList measureNodes = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

        for (int i = 0; i < measureNodes.getLength(); i++){
            Element measureElement = (Element) measureNodes.item(i);
            String table = measureElement.getAttribute("table");
            if (!table.isEmpty()) {
                factTableNames.add(table);
            }
        }

        return factTableNames;
    }

}
