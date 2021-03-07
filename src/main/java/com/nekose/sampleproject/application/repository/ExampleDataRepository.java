package com.nekose.sampleproject.application.repository;

import com.nekose.sampleproject.controller.request.ExampleRequest;
import com.nekose.sampleproject.infrastructure.kvs.dto.ExampleDto;

import java.util.Optional;

public interface ExampleDataRepository {
    Optional<ExampleDto> get(String key);

    void store(String key, ExampleDto value);

    void delete(String key);
}
