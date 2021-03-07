package com.nekose.sampleproject.application;

import com.nekose.sampleproject.application.repository.ExampleDataRepository;
import com.nekose.sampleproject.application.service.ExampleDataService;
import com.nekose.sampleproject.controller.request.ExampleRequest;
import com.nekose.sampleproject.domain.model.entity.ExampleData;
import com.nekose.sampleproject.infrastructure.kvs.dto.ExampleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleApplication {
    private ExampleDataRepository exampleDataRepository;
    private ExampleDataService exampleDataService;

    public ExampleData get(String key) {
        return exampleDataRepository.get(key)
                .map(dto -> exampleDataService.getExampleData(dto))
                .orElse(ExampleData.builder().build());
    }

    public ExampleData store(ExampleRequest request) {
        var key = request.getKey();
        exampleDataRepository.store(key, ExampleDto.from(request));
        return this.get(key);
    }

    public void delete(String key) {
        exampleDataRepository.delete(key);
    }
}
