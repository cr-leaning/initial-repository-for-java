package com.nekose.sampleproject.domain.service;

import com.nekose.sampleproject.application.service.DummyDataService;
import com.nekose.sampleproject.domain.model.entity.DummyData;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiResponse;
import org.springframework.stereotype.Service;

@Service
public class DummyDataServiceImpl implements DummyDataService {
    @Override
    public DummyData getDummyData(String key, DummyApiResponse dummyApiResponse) {
        return null;
    }
}
