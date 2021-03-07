package com.nekose.sampleproject.infrastructure.kvs.dto;

import com.nekose.sampleproject.controller.request.ExampleRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExampleDto implements Serializable {
    private String name;
    private String value;

    public static ExampleDto from(ExampleRequest request) {
        return ExampleDto.builder()
                .name(request.getName())
                .value(request.getValue())
                .build();
    }
}
