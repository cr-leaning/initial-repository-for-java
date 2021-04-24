package com.nekose.sampleproject.infrastructure.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DummyApiErrorResponse {
    @JsonProperty("message")
    private String message;
    @JsonProperty("detail")
    private String detail;
}
