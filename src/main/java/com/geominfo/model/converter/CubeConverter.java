package com.geominfo.model.converter;

import com.geominfo.model.cube.Cube;
import com.geominfo.model.cube.Field;
import com.geominfo.model.cube.FieldTree;
import com.geominfo.model.cube.Attribute;
import com.geominfo.model.cube.SqlPlaceholder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import com.alibaba.fastjson.JSONObject;

import javax.xml.xpath.*;
import java.util.*;

/**
 * @author Pu
 * @since 2024/7/19
 */
public class CubeConverter {

    private final Document document;

    private final Cube cube = new Cube();

    /**
     * key uid, value attribute name
     */
    private final Map<String, String> attrMap = new HashMap<>();

    private static final XPath xPath = XPathFactory.newInstance().newXPath();

    public CubeConverter(Document document) {
        this.document = document;
    }


    public Cube convert() throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("//Cube");
        Element cubeElement = (Element) xPathExpression.evaluate(document, XPathConstants.NODE);
        cube.setCubeId(UUID.randomUUID().toString());
        cube.setCaption(cubeElement.getAttribute("caption"));

        CubeConverter cubeConverter = this.convertFieldTree()
                .convertFields()
                .convertSqlPlaceholders();
        return cubeConverter.cube;
    }


    public CubeConverter convertFieldTree() throws XPathExpressionException {
        // measures
        NodeList measureNodes = (NodeList)xPath.compile("//Measures/Measure")
                .evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < measureNodes.getLength(); i++) {
            Element measureElement = (Element)measureNodes.item(i);
            if (measureElement.hasAttribute("visible") &&
                    "false".equals(measureElement.getAttribute("visible"))) {
                continue;
            }

            String table = measureElement.getAttribute("table");
            Optional<FieldTree> measureFolderOpt = cube.getFieldTree().stream()
                    .filter(f -> f.getName().equals(table) && f.getType().equals("folder"))
                    .findAny();

            FieldTree measureFolder = new FieldTree();
            if (measureFolderOpt.isPresent()) {
                measureFolder = measureFolderOpt.get();
            }else {
                // add
                measureFolder.setId(attrMap.get(table));
                measureFolder.setName(table);
                measureFolder.setType("folder");
                measureFolder.setChildren(new ArrayList<>());
                cube.getFieldTree().add(measureFolder);
            }

            FieldTree child = new FieldTree();
            child.setId(attrMap.get(table));
            child.setName(measureElement.getAttribute("caption"));
            child.setType("attribute");
            child.setChildren(Collections.emptyList());
            measureFolder.getChildren().add(child);
        }

        // dimensions
        NodeList dimensionNodes = (NodeList)xPath.compile("//Dimensions/Dimension")
                .evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < dimensionNodes.getLength(); i++) {
            Element dimElement = (Element)dimensionNodes.item(i);

            String caption = dimElement.getAttribute("caption");
            Optional<FieldTree> dimFolderOpt = cube.getFieldTree().stream()
                    .filter(f -> f.getName().equals(caption) && f.getType().equals("folder"))
                    .findAny();
            if (dimFolderOpt.isPresent()) {
                continue;
            }

            FieldTree dimFolder = new FieldTree();
            dimFolder.setId(attrMap.get(caption));
            dimFolder.setName(caption);
            dimFolder.setType("folder");
            dimFolder.setChildren(new ArrayList<>());
            cube.getFieldTree().add(dimFolder);

            NodeList attributeNodes = dimElement.getElementsByTagName("Attribute");
            for (int j = 0; j < attributeNodes.getLength(); j++) {
                Element attrElement = (Element)attributeNodes.item(j);
                if (attrElement.hasAttribute("visible") &&
                        "false".equals(attrElement.getAttribute("visible"))) {
                    continue;
                }

                FieldTree attrField = new FieldTree();
                attrField.setId(attrMap.get(caption));
                attrField.setName(attrElement.getAttribute("caption"));
                attrField.setType("attribute");
                attrField.setChildren(Collections.emptyList());
                dimFolder.getChildren().add(attrField);
            }
        }
        return this;
    }


    private CubeConverter convertFields() throws XPathExpressionException {
        // measures
        NodeList measureNodes = (NodeList)xPath.compile("//Measures/Measure")
                .evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < measureNodes.getLength(); i++) {
            Element measureElement = (Element)measureNodes.item(i);

            String expr = null;
            NodeList annotationNodes = measureElement.getElementsByTagName("Annotation");
            for (int j = 0 ; j < annotationNodes.getLength(); j++) {
                Element annotationElement = (Element)annotationNodes.item(j);
                if (annotationElement.getAttribute("name").equals("def")) {
                    expr = annotationElement.getTextContent().trim();
                }
            }

            boolean visible = !measureElement.hasAttribute("visible") ||
                    !("false".equals(measureElement.getAttribute("visible")));
            String uid = UUID.randomUUID().toString();
            attrMap.put(measureElement.getAttribute("caption"), uid);

            Field calcField = new Field();
            calcField.setUniqueId(uid);
            calcField.setCaption(measureElement.getAttribute("caption"));
            calcField.setType("Measure");
            calcField.setTable(PhysicalSchemaConverter.tableMap.get(measureElement.getAttribute("table")));
            calcField.setCalculateMember(!(expr == null || expr.isEmpty()));
            calcField.setAttributes(
                    Collections.singletonList(
                            new Attribute.Builder()
                                    .uniqueId(uid)
                                    .visible(visible)
                                    .caption(measureElement.getAttribute("caption"))
                                    .aggregator(measureElement.getAttribute("aggregator"))
                                    .dataType("Numeric".equals(measureElement.getAttribute("datatype")) ?
                                        "number" : measureElement.getAttribute("datatype").toLowerCase())
                                    .expression(expr)
                                    .build()
                    )
            );
            cube.getFields().add(calcField);
        }

        // dimensions
        NodeList dimAttrNodes = (NodeList)xPath.compile("//Dimensions/Dimension/Attributes/Attribute")
                .evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < dimAttrNodes.getLength(); i++) {
            Element dimAttrElement = (Element)dimAttrNodes.item(i);

            String expr = null;
            NodeList annotationNodes = dimAttrElement.getElementsByTagName("Annotation");
            for (int j = 0 ; j < annotationNodes.getLength(); j++) {
                Element annotationElement = (Element)annotationNodes.item(j);
                if (annotationElement.getAttribute("name").equals("info")) {
                    expr = JSONObject
                            .parseObject(annotationElement.getTextContent())
                            .getString("inputVal");
                }
            }

            boolean visible = !dimAttrElement.hasAttribute("visible") ||
                    !("false".equals(dimAttrElement.getAttribute("visible")));
            String uid = UUID.randomUUID().toString();
            attrMap.put(dimAttrElement.getAttribute("caption"), uid);

            Field calcField = new Field();
            calcField.setUniqueId(uid);
            calcField.setCaption(dimAttrElement.getAttribute("caption"));
            calcField.setType("Dimension");
            calcField.setTable(PhysicalSchemaConverter.tableMap.get(dimAttrElement.getAttribute("table")));
            calcField.setCalculateMember(!(expr == null || expr.isEmpty()));
            calcField.setAttributes(
                    Collections.singletonList(
                            new Attribute.Builder()
                                    .uniqueId(uid)
                                    .visible(visible)
                                    .caption(dimAttrElement.getAttribute("caption"))
                                    .aggregator(dimAttrElement.getAttribute("aggregator"))
                                    .dataType("Numeric".equals(dimAttrElement.getAttribute("datatype")) ?
                                            "number" : dimAttrElement.getAttribute("datatype").toLowerCase())
                                    .expression(expr)
                                    .build()
                    )
            );
            cube.getFields().add(calcField);
        }

        return this;
    }



    public CubeConverter convertSqlPlaceholders() throws XPathExpressionException {
        NodeList sqlPlaceHolderNodes = (NodeList)xPath.compile("//SqlPlaceHolders/SqlPlaceHolder")
                .evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < sqlPlaceHolderNodes.getLength(); i++){
            Element element = (Element)sqlPlaceHolderNodes.item(i);

            SqlPlaceholder sqlPlaceholder = new SqlPlaceholder();
            sqlPlaceholder.setUniqueId(UUID.randomUUID().toString());
            sqlPlaceholder.setUseInGlobal(Boolean.parseBoolean(element.getAttribute("useInGlobal")));
            sqlPlaceholder.setName(element.getAttribute("caption"));
            sqlPlaceholder.setType("string");
            sqlPlaceholder.setDefaultValue(element.getAttribute("defaultValues"));
            cube.getSqlPlaceholders().add(sqlPlaceholder);
        }
        return this;
    }
}
