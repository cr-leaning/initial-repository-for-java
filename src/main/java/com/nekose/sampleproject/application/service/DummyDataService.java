package com.nekose.sampleproject.application.service;

import com.nekose.sampleproject.domain.model.entity.DummyData;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiResponse;

public interface DummyDataService {
    DummyData getDummyData(String key, DummyApiResponse dummyApiResponse);
}
