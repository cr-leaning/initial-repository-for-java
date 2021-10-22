//package com.nekose.sampleproject;
//
//import com.nekose.sampleproject.domain.model.entity.DummyData;
//
//@QuarkusTest
//public class DummyDataTest extends ItBase {
//    private static final String URI = "/v1/dummy/{key}";
//
//    @Test
//    void getDummyData() {
//        var response = testRestTemplate.getForEntity(
//                URI.replace("{key}", "testKey"),
//                String.class
//        );
//
//        assertAll(
//                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                () -> {
//                    var responseBody = new ObjectMapper().readValue(response.getBody(), DummyData.class);
//                    assertAll(
//                            () -> assertEquals("test name", responseBody.getName()),
//                            () -> assertEquals("test value", responseBody.getValue())
//                    );
//                }
//        );
//    }
//}
