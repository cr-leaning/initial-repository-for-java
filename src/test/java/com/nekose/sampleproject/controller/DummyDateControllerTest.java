package com.nekose.sampleproject.controller;

import com.nekose.sampleproject.application.DummyApplication;
import com.nekose.sampleproject.domain.model.entity.DummyData;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@QuarkusTest
class DummyDateControllerTest {
    private static final String BASE_URI = "/v1/dummy";
    private static final String URI_GET = BASE_URI + "/{key}";

    @Mock
    private DummyApplication dummyApplication;
    @InjectMocks
    private DummyDateController target;

    @Test
    void get_normal() throws Exception {
        String exceptedKey = "testKey";

        var mockDummyData = DummyData.builder()
                .key(exceptedKey)
                .name("testName")
                .value("testValue")
                .build();
        when(dummyApplication.get(any()))
                .thenReturn(mockDummyData);

        RestAssured.when().get(URI_GET, exceptedKey)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType("application/json")
                .body(containsString("{\"resultInfo\":{" +
                        "\"status\":\"SUCCESS\"," +
                        "\"statusReason\":\"success\"" +
                        "}," +
                        "\"data\":{" +
                        "\"key\":\"testKey\"," +
                        "\"name\":\"testName\"," +
                        "\"value\":\"testValue\"" +
                        "}}"));

        var captor = ArgumentCaptor.forClass(String.class);
        verify(dummyApplication, times(1)).get(captor.capture());

        assertEquals(exceptedKey, captor.getValue());
    }

}
