package com.nekose.sampleproject.domain.model.entity;

import com.nekose.sampleproject.infrastructure.kvs.dto.ExampleDto;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DummyData {
    private String key;
    private String name;
    private String value;

    public static DummyData from(String key, ExampleDto exampleDto) {
        return DummyData.builder()
                .key(key)
                .name(exampleDto.getName())
                .value(exampleDto.getValue())
                .build();
    }
}
