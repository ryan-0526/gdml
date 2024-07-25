package com.geominfo.gselect;

import com.alibaba.fastjson.JSON;
import com.geominfo.bi.ThinQuery;
import com.geominfo.model.Schema;

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
                "                    },\n" +
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


    public static ThinQuery getThinQuery2() {

        String queryJson = "{\n" +
                "    \"componentId\": \"8rb1bcg8\",\n" +
                "    \"componentName\": \"线图\",\n" +
                "    \"configs\": [\n" +
                "        {\n" +
                "            \"type\": \"field\",\n" +
                "            \"config\": {\n" +
                "                \"fields\": [\n" +
                "                    {\n" +
                "                        \"fid\": \"f5b2205d-6d17-47c0-8f35-e7014c32d903\",\n" +
                "                        \"areaType\": \"column\",\n" +
                "                        \"aggregate\": \"sum\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"bb7a3047-3e6b-47bc-8016-1896f9f354e9\",\n" +
                "                        \"areaType\": \"row\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"30addada-b9ba-437c-b933-6bb88fefb788\",\n" +
                "                        \"areaType\": \"column\",\n" +
                "                        \"aggregate\": \"sum\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"fid\": \"1c4fed46-9cd4-4b3c-9191-3a39a8637380\",\n" +
                "                        \"areaType\": \"row\"\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "            \"cubeId\": \"244e451f-accd-4c63-a240-cf9d35e0d5cd\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"paging\",\n" +
                "            \"cubeId\": \"244e451f-accd-4c63-a240-cf9d35e0d5cd\",\n" +
                "            \"config\": {\n" +
                "                \"limit\": 1000,\n" +
                "                \"offset\": 0\n" +
//                "                \"pagedByAllDim\": true\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\": \"beforeCondition\",\n" +
                "            \"cubeId\": \"244e451f-accd-4c63-a240-cf9d35e0d5cd\",\n" +
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
                "            \"cubeId\": \"244e451f-accd-4c63-a240-cf9d35e0d5cd\",\n" +
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

    }


    public static Schema getSchema() {
        String model = "{\n" +
                "    \"cube\": {\n" +
                "        \"caption\": \"动态参数测试\",\n" +
                "        \"cubeId\": \"3bb704a2-31b8-4cd6-a9fe-f8402e88bd29\",\n" +
                "        \"fieldTree\": [\n" +
                "            {\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"DATE_ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"PATIENT_SOURCE\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"BILLING_OFFICE_ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"BILLING_PERSON_ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"PATIENT_TIMES\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"DRUG_MONEY\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"总金额\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"DRUG_BREED\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"BASE_DRUG_BREED\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"BASE_DRUG_MONEY\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"EXECUTE_OFFICE_ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"CHINESE_DRUG_MONEY\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"AUXILIARY_DRUG_MONEY\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"CHINESE_PATENT_MONEY\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"MATERIAL_MONEY\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"WESTERN_DRUG_MONEY\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"NATIONAL_COLL_DRUG_MONEY\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"DRUG_MONEY_GT\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"BASE_DRUG_TIMES\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"药占比成员\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\": \"动态参数测试\",\n" +
                "                \"type\": \"folder\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"children\": [\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"院区名称\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"RESOURCE_ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"LAST_UPLOAD_TIME1\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"IS_REJECT\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"ENV_TYPE_ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"OFFICE_CLASSIFY_ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"STATISTICS_PROPERTY\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"POSITION\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"CREATE_TIME\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"科室名称\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"一级科室名称\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"CUSTOM_CODE\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"DISPLAY_ORDER\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"PHONETIC_CODE\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"HOSPITAL_DIS\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"UPDATE_TIME\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"编制床位数\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"PARENT_ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"CODE\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"CLINICAL_OFFICE_ID\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"开放床位数\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"IS_FINAL_STAGE\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"RESPONSIBLE_PEOPLE\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"children\": [\n" +
                "\n" +
                "                        ],\n" +
                "                        \"name\": \"RECORD_STATE\",\n" +
                "                        \"type\": \"attribute\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"name\": \"部门属性\",\n" +
                "                \"type\": \"folder\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"fields\": [\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"ID\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"a60fcd3b-5b2d-489d-a90b-44edeb31136d\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"DATE_ID\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"2b33eacb-ffed-4a9d-b12a-63ed3e49645f\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"PATIENT_SOURCE\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"d4605f15-4b68-4fa4-a5e6-515a00e394e2\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"BILLING_OFFICE_ID\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"d5145c99-bc67-4c81-916f-755e52876949\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"BILLING_PERSON_ID\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"b36d76e1-e769-45ad-b09c-83c99798d556\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"PATIENT_TIMES\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"6265e2ba-b83f-4228-8372-5efaef2fcd42\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"DRUG_MONEY\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"30addada-b9ba-437c-b933-6bb88fefb788\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"总金额\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"1ab105e9-0b56-4400-ab7a-f680c0244e87\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"DRUG_BREED\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"f5b2205d-6d17-47c0-8f35-e7014c32d903\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"BASE_DRUG_BREED\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"0a6d8bcc-8d41-41a3-a3a1-521c1f8657be\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"BASE_DRUG_MONEY\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"eacdab7e-4af4-41b1-827f-506fc34a9d65\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"EXECUTE_OFFICE_ID\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"61a6fec1-cf2a-4292-8185-dc968e9b235b\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"CHINESE_DRUG_MONEY\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"4c490795-c628-41a9-baa4-2ff7d17f82ae\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"AUXILIARY_DRUG_MONEY\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"bc442930-b87a-4953-a40b-cf669b53f5a6\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"CHINESE_PATENT_MONEY\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"9f4d582d-0c91-4153-85b3-d15c89796eef\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"MATERIAL_MONEY\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"bb871cc0-2151-4da0-b33d-e95ed81b7061\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"WESTERN_DRUG_MONEY\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"c3f4b10c-af70-459a-88ab-41ea29428646\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"NATIONAL_COLL_DRUG_MONEY\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"7145a029-c64f-4486-887d-793d5358582a\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"DRUG_MONEY_GT\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"bf01d519-51d6-4d27-ae42-fd9fb97c5c61\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"BASE_DRUG_TIMES\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"68d1da9b-7478-48e6-ad3e-c0be2818647a\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": true,\n" +
                "                \"caption\": \"药占比成员\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Measure\",\n" +
                "                \"uniqueId\": \"6375147d-faef-4a9d-8b6d-158670bc2d30\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"CAL_DATE\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"4fc28ba9-da80-46ab-89ad-a8cd29087355\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"LAST_UPLOAD_TIME\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"2874cc42-afad-4972-9019-050981002f32\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"MEDICALCODE\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"d38ba05e-fc63-4069-8cb9-727fa1d09290\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"CAL_YEAR\",\n" +
                "                \"table\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"55c4388f-34c5-402d-88a3-f626b3bf744c\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"院区名称\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"99708f9a-4b8a-498a-a289-0e75976dcf3a\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"RESOURCE_ID\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"0b2e38bb-63f5-4695-a932-3772b7fb1e6a\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"LAST_UPLOAD_TIME1\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"6a566928-4e59-4c44-bbef-64fddcc17578\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"IS_REJECT\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"04fa1917-15d9-4ae3-b9d5-8d20be9a0da2\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"ENV_TYPE_ID\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"6202bc7d-a354-468c-ad6b-8fa8e4a7e66d\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"OFFICE_CLASSIFY_ID\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"20c47ee0-941a-488c-bb84-c90eae58bb3f\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"STATISTICS_PROPERTY\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"12d6fad1-2096-4d71-95f5-58f292a4b7c9\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"POSITION\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"0b1ea018-1246-4f07-acdd-2f7ca545e136\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"ID\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"2ae636f9-2af4-4733-9faf-c37fcced78cb\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"CREATE_TIME\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"bc8a18b1-6f60-47ef-a9e0-83b26ebcb248\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"科室名称\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"bb7a3047-3e6b-47bc-8016-1896f9f354e9\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"一级科室名称\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"3bf3657f-f148-40c5-829e-c48dae42ac1a\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"CUSTOM_CODE\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"68f3501f-32c9-4b87-9df0-ebc2040fa686\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"DISPLAY_ORDER\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"477ee1bf-fd9f-4a2d-90b7-34d5dae23d7a\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"PHONETIC_CODE\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"9faf53f0-ecc6-4a93-891e-2e84549f4eea\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"HOSPITAL_DIS\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"0ae797a0-2bfa-4da3-bc5d-5ade64708b90\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"UPDATE_TIME\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"0ba79884-07a0-4a40-9e7a-b6515b91519f\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"编制床位数\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"b0da861d-dacc-4b93-b126-3b91d5dc0142\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"PARENT_ID\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"630ed971-e487-4ca7-a3f3-3dcddef77990\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"CODE\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"aa3bfcf8-71e5-46d7-b7db-cdeaf2af7dc0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"CLINICAL_OFFICE_ID\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"959dd0c7-ed65-4b91-80b4-e6d3b63f7af0\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"开放床位数\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"1c4fed46-9cd4-4b3c-9191-3a39a8637380\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"IS_FINAL_STAGE\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"c755101d-1611-4c62-8093-76136b901532\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"RESPONSIBLE_PEOPLE\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"68673810-d4c4-4896-8c96-7cfcd5ac1681\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"calculateMember\": false,\n" +
                "                \"caption\": \"RECORD_STATE\",\n" +
                "                \"table\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\",\n" +
                "                \"type\": \"Dimension\",\n" +
                "                \"uniqueId\": \"7a693787-d41a-48c3-b26b-491455fe026d\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"sqlPlaceholders\": [\n" +
                "            {\n" +
                "                \"defaultValue\": \"\",\n" +
                "                \"name\": \"start_date\",\n" +
                "                \"type\": \"string\",\n" +
                "                \"uniqueId\": \"07cd7001-33db-42da-a071-bf5e825ce9bc\",\n" +
                "                \"useInGlobal\": true\n" +
                "            },\n" +
                "            {\n" +
                "                \"defaultValue\": \"\",\n" +
                "                \"name\": \"end_date\",\n" +
                "                \"type\": \"string\",\n" +
                "                \"uniqueId\": \"d95331f0-e42b-4a20-b1a7-4cccd0512424\",\n" +
                "                \"useInGlobal\": true\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"physicalSchema\": {\n" +
                "        \"links\": [\n" +
                "            {\n" +
                "                \"joinKeys\": [\n" +
                "                    {\n" +
                "                        \"sourceKey\": \"BILLING_OFFICE_ID\",\n" +
                "                        \"targetKey\": \"ID\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"joinType\": \"inner\",\n" +
                "                \"source\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\",\n" +
                "                \"target\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"tables\": [\n" +
                "            {\n" +
                "                \"caption\": \"部门属性\",\n" +
                "                \"datasourceId\": \"468966\",\n" +
                "                \"dsType\": \"oracle\",\n" +
                "                \"factTable\": false,\n" +
                "                \"name\": \"T_OFFICE_PROPERTY\",\n" +
                "                \"schema\": \"INMON\",\n" +
                "                \"uniqueId\": \"8f09be1a-0006-42af-9aaa-cc07cd7d7b76\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"virtualTables\": [\n" +
                "            {\n" +
                "                \"caption\": \"动态参数测试\",\n" +
                "                \"datasourceId\": \"468966\",\n" +
                "                \"dsType\": \"oracle\",\n" +
                "                \"factTable\": true,\n" +
                "                \"fields\": [\n" +
                "                    {\n" +
                "                        \"caption\": \"ID\",\n" +
                "                        \"column\": \"ID\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"DATE_ID\",\n" +
                "                        \"column\": \"DATE_ID\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"PATIENT_SOURCE\",\n" +
                "                        \"column\": \"PATIENT_SOURCE\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"BILLING_OFFICE_ID\",\n" +
                "                        \"column\": \"BILLING_OFFICE_ID\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"BILLING_PERSON_ID\",\n" +
                "                        \"column\": \"BILLING_PERSON_ID\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"PATIENT_TIMES\",\n" +
                "                        \"column\": \"PATIENT_TIMES\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"DRUG_MONEY\",\n" +
                "                        \"column\": \"DRUG_MONEY\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"总金额\",\n" +
                "                        \"column\": \"TOTAL_MONEY\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"DRUG_BREED\",\n" +
                "                        \"column\": \"DRUG_BREED\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"BASE_DRUG_BREED\",\n" +
                "                        \"column\": \"BASE_DRUG_BREED\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"BASE_DRUG_MONEY\",\n" +
                "                        \"column\": \"BASE_DRUG_MONEY\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"EXECUTE_OFFICE_ID\",\n" +
                "                        \"column\": \"EXECUTE_OFFICE_ID\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"CHINESE_DRUG_MONEY\",\n" +
                "                        \"column\": \"CHINESE_DRUG_MONEY\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"AUXILIARY_DRUG_MONEY\",\n" +
                "                        \"column\": \"AUXILIARY_DRUG_MONEY\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"CHINESE_PATENT_MONEY\",\n" +
                "                        \"column\": \"CHINESE_PATENT_MONEY\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"MATERIAL_MONEY\",\n" +
                "                        \"column\": \"MATERIAL_MONEY\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"WESTERN_DRUG_MONEY\",\n" +
                "                        \"column\": \"WESTERN_DRUG_MONEY\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"NATIONAL_COLL_DRUG_MONEY\",\n" +
                "                        \"column\": \"NATIONAL_COLL_DRUG_MONEY\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"DRUG_MONEY_GT\",\n" +
                "                        \"column\": \"DRUG_MONEY_GT\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"BASE_DRUG_TIMES\",\n" +
                "                        \"column\": \"BASE_DRUG_TIMES\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"caption\": \"药占比成员\",\n" +
                "                        \"column\": \"药占比成员_xqh\",\n" +
                "                        \"dataType\": \"Numeric\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"sql\": \"SELECT fdu.*,td.CAL_DATE,td.CAL_YEAR  FROM F_DRUG_USE fdu LEFT JOIN T_DATES td ON fdu.DATE_ID = td.ID WHERE td.CAL_DATE >= '${start_date}' AND td.CAL_DATE <= '${end_date}'\",\n" +
                "                \"tableName\": \"TS1721896613287\",\n" +
                "                \"uniqueId\": \"73841d7d-b83c-4680-81a0-20c63036f8b2\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        return JSON.parseObject(model, Schema.class);
    }
}
