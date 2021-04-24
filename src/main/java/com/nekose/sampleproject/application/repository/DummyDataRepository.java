package com.nekose.sampleproject.application.repository;

import com.nekose.sampleproject.infrastructure.client.request.DummyApiRequest;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiResponse;

import java.util.Optional;

public interface DummyDataRepository {
    Optional<DummyApiResponse> get(String key);

    void store(String key, DummyApiRequest value);

    void delete(String key);
}
