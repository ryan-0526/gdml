package com.geominfo.gselect;

import com.alibaba.fastjson.JSON;
import com.geominfo.bi.ThinQuery;

public class JsonTest {

    public static ThinQuery getThinQuery() {
        String queryJson = "{\n" +
                "    \"componentId\": \"8rb1bcg8\",\n" +
                "    \"componentName\": \"线图\",\n" +
                "    \"configs\": [\n" +
                "        {\n" +
                "            \"type\": \"field\",\n" +
                "            \"config\": {\n" +
                "                \"fields\": [\n" +
                "                    {\n" +
                "                        \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_LAST_UPLOAD_TIME].[Nb08c34_LAST_UPLOAD_TIME].[496512478_quarterRange]\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"quarter\"\n" +
                "                    }\n" +
                "                    {\n" +
                "                        \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_LAST_UPLOAD_TIME].[Nb08c34_LAST_UPLOAD_TIME].[496512478_hourRange]\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"hour\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_LAST_UPLOAD_TIME].[Nb08c34_LAST_UPLOAD_TIME].[496512478_dayRange]\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"day\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_LAST_UPLOAD_TIME].[Nb08c34_LAST_UPLOAD_TIME].[496512478_weekRange]\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"week\",\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_LAST_UPLOAD_TIME].[Nb08c34_LAST_UPLOAD_TIME].[496512478_monthRange]\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"month\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_LAST_UPLOAD_TIME].[Nb08c34_LAST_UPLOAD_TIME].[496512478_yearRange]\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"year\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"032f474e26\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"quarter\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"571c30bcb1\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"week\",\n" +
//                "                        \"firstDay\": 1\n" +
                "                        \"sortType\": \"asc\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"bca50037d4\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"day\",\n" +
                "                        \"sortType\": \"asc\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"e4103af934\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"month\",\n" +
                "                        \"sortType\": \"asc\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"55c09fb0d9\",\n" +
                "                        \"areaType\": \"row\",\n" +
                "                        \"dateTrunc\": \"year\",\n" +
                "                        \"sortType\": \"asc\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_DRUG_REVENUE]\",\n" +
                "                        \"areaType\": \"column\",\n" +
                "                        \"aggregate\": \"sum\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_OUTPATIENT_REVENUE]\",\n" +
                "                        \"areaType\": \"column\",\n" +
                "                        \"aggregate\": \"sum\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_COMPENSATE_PAY]\",\n" +
                "                        \"areaType\": \"column\",\n" +
                "                        \"aggregate\": \"sum\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"cubeId\": \"b08c34ef-873f-4eef-8b98-89c1c1953a96\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"paging\",\n" +
                "            \"cubeId\": \"b08c34ef-873f-4eef-8b98-89c1c1953a96\",\n" +
                "            \"config\": {\n" +
                "                \"limit\": 1000,\n" +
                "                \"offset\": 0\n" +
//                "                \"pagedByAllDim\": true\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"beforeCondition\",\n" +
                "            \"cubeId\": \"b08c34ef-873f-4eef-8b98-89c1c1953a96\",\n" +
                "            \"config\": {\n" +
                "                \"logicalOperator\": \"AND\",\n" +
                "                \"conditions\": [\n" +
                "                    {\n" +
                "                        \"logicalOperator\": \"OR\",\n" +
                "                        \"conditions\": [\n" +
                "                            {\n" +
                "                                \"field\": {\n" +
                "                                    \"fid\": \"db43fb24a3\"\n" +
                "                                },\n" +
                "                                \"functionalOperator\": \"equalTo\",\n" +
                "                                \"args\": [\n" +
                "                                    {\n" +
                "                                        \"valueType\": \"string\",\n" +
                "                                        \"value\": \"1\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"field\": {\n" +
                "                                    \"fid\": \"db43fb24a3\"\n" +
                "                                },\n" +
                "                                \"functionalOperator\": \"equalTo\",\n" +
                "                                \"args\": [\n" +
                "                                    {\n" +
                "                                        \"valueType\": \"string\",\n" +
                "                                        \"value\": \"2\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"logicalOperator\": \"and\",\n" +
                "                        \"conditions\": [\n" +
                "                            {\n" +
                "                                \"field\": {\n" +
                "                                    \"fid\": \"c0be556082\"\n" +
                "                                },\n" +
                "                                \"functionalOperator\": \"equalTo\",\n" +
                "                                \"args\": [\n" +
                "                                    {\n" +
                "                                        \"valueType\": \"string\",\n" +
                "                                        \"value\": \"1\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"field\": {\n" +
                "                                    \"fid\": \"c0be556082\"\n" +
                "                                },\n" +
                "                                \"functionalOperator\": \"equalTo\",\n" +
                "                                \"args\": [\n" +
                "                                    {\n" +
                "                                        \"valueType\": \"string\",\n" +
                "                                        \"value\": \"2\"\n" +
                "                                    }\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                    {\n" +
                "                        \"field\": {\n" +
                "                            \"fid\": \"a191999b37\"\n" +
                "                        },\n" +
                "                        \"functionalOperator\": \"in\",\n" +
                "                        \"args\": [\n" +
                "                            {\n" +
                "                                \"valueType\": \"string\",\n" +
                "                                \"value\": \"2020-04\"\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"afterCondition\",\n" +
                "            \"cubeId\": \"b08c34ef-873f-4eef-8b98-89c1c1953a96\",\n" +
                "            \"config\": {\n" +
                "                \"logicalOperator\": \"or\",\n" +
                "                \"conditions\": [\n" +
                "                    {\n" +
                "                        \"field\": {\n" +
                "                            \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_DRUG_REVENUE]\",\n" +
                "                            \"aggregate\": \"sum\"\n" +
                "                        },\n" +
                "                        \"functionalOperator\": \"equalTo\",\n" +
                "                        \"args\": [\n" +
                "                            {\n" +
                "                                \"valueType\": \"number\",\n" +
                "                                \"value\": 1\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"field\": {\n" +
                "                            \"fid\": \"e6484f9c-56bb-4802-9ad7-cfcb3b4ce933.b08c34ef-873f-4eef-8b98-89c1c1953a96.[Nb08c34_DRUG_REVENUE]\",\n" +
                "                            \"aggregate\": \"sum\"\n" +
                "                        },\n" +
                "                        \"functionalOperator\": \"equalTo\",\n" +
                "                        \"args\": [\n" +
                "                            {\n" +
                "                                \"valueType\": \"number\",\n" +
                "                                \"value\": 2\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        }" +
                "    ],\n" +
                "    \"dataType\": \"general\"\n" +
                "}";

        return JSON.parseObject(queryJson, ThinQuery.class);
//        List<QueryConfig> configs = thinQuery.getConfigs();
//        for (QueryConfig config: configs) {
////            List<SqlConfig> config1 = config.getConfig();
////            for (SqlConfig sqlConfig: config1) {
////                List<FieldInfo> fields = sqlConfig.getFields();
////
////            }
//        }
//
//        System.out.println(thinQuery.toString());
    }
}
