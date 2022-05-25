package com.nekose.sampleproject.application;

import com.nekose.sampleproject.application.repository.DummyDataRepository;
import com.nekose.sampleproject.application.service.DummyDataService;
import com.nekose.sampleproject.controller.request.DummyRequest;
import com.nekose.sampleproject.domain.model.entity.DummyData;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DummyApplication {
    private final DummyDataRepository dummyDataRepository;
    private final DummyDataService dummyDataService;

    public DummyData get(String key) {
        throw new NotImplementedException("omit redis method");
//        return dummyDataRepository.get(key)
//                .map(response -> dummyDataService.getDummyData(key, response))
//                .orElse(DummyData.builder().build());
    }

    public DummyData store(DummyRequest request) {
        throw new NotImplementedException("omit redis method");
//        var key = request.getKey();
//        dummyDataRepository.store(key, DummyApiRequest.from(request));
//        return this.get(key);
    }

    public void delete(String key) {
        throw new NotImplementedException("omit redis method");
//        dummyDataRepository.delete(key);
    }
}
