package com.nekose.sampleproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nekose.sampleproject.domain.model.entity.DummyData;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyDataTest extends ItBase {
    private static final String URI = "/v1/dummy/{key}";

    @Test
    void getDummyData() {
        var response = testRestTemplate.getForEntity(
                URI.replace("{key}", "testKey"),
                String.class
        );

        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> {
                    var responseBody = new ObjectMapper().readValue(response.getBody(), DummyData.class);
                    assertAll(
                            () -> assertEquals("test name", responseBody.getName()),
                            () -> assertEquals("test value", responseBody.getValue())
                    );
                }
        );
    }
}
