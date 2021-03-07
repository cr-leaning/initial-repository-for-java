package com.nekose.sampleproject.application.service;

import com.nekose.sampleproject.domain.model.entity.ExampleData;
import com.nekose.sampleproject.infrastructure.kvs.dto.ExampleDto;

public interface ExampleDataService {
    ExampleData getExampleData(String key, ExampleDto exampleDto);
}
