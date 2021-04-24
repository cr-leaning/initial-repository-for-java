package com.nekose.sampleproject.infrastructure.client.request;

import com.nekose.sampleproject.controller.request.DummyRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DummyApiRequest implements Serializable {
    private String name;
    private String value;

    public static DummyApiRequest from(DummyRequest request) {
        return DummyApiRequest.builder()
                .name(request.getName())
                .value(request.getValue())
                .build();
    }
}
