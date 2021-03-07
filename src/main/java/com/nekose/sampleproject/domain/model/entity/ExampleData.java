package com.nekose.sampleproject.domain.model.entity;

import com.nekose.sampleproject.infrastructure.kvs.dto.ExampleDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ExampleData {
    private String key;
    private String name;
    private String value;

    public static ExampleData from(String key, ExampleDto exampleDto) {
        return ExampleData.builder()
                .key(key)
                .name(exampleDto.getName())
                .value(exampleDto.getValue())
                .build();
    }
}
