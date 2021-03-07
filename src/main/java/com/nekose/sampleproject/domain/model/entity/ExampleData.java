package com.nekose.sampleproject.domain.model.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ExampleData {
    private String key;
    private String name;
    private String value;
}
