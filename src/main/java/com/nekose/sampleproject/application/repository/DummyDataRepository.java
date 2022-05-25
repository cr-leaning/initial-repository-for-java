package com.nekose.sampleproject.application.repository;

import com.nekose.sampleproject.exception.ApiClientException;
import com.nekose.sampleproject.infrastructure.client.request.DummyApiRequest;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiResponse;

import java.util.Optional;

public interface DummyDataRepository {
    Optional<DummyApiResponse> get(String key) throws ApiClientException;

    void store(String key, DummyApiRequest value) throws ApiClientException;

    void delete(String key) throws ApiClientException;
}
