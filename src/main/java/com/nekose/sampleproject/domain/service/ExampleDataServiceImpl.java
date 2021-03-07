package com.nekose.sampleproject.domain.service;

import com.nekose.sampleproject.application.service.ExampleDataService;
import com.nekose.sampleproject.domain.model.entity.ExampleData;
import com.nekose.sampleproject.infrastructure.kvs.dto.ExampleDto;
import org.springframework.stereotype.Service;

@Service
public class ExampleDataServiceImpl implements ExampleDataService {
    @Override
    public ExampleData getExampleData(String key, ExampleDto exampleDto) {
        return ExampleData.from(key, exampleDto);
    }
}
