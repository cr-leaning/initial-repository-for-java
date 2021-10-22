package com.nekose.sampleproject.infrastructure.client;

import com.nekose.sampleproject.application.repository.DummyDataRepository;
import com.nekose.sampleproject.exception.ApiClientException;
import com.nekose.sampleproject.infrastructure.client.request.DummyApiRequest;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DummyDataRepositoryImpl implements DummyDataRepository {
    @Inject
    @RestClient
    DummyApiClient dummyApiClient;

    private static final String ERROR_MASSAGE = "Unexpected Exception: {}";

    @Override
    public Optional<DummyApiResponse> get(String key) throws ApiClientException {
        try {
            return Optional.ofNullable(dummyApiClient.getDummyData("testBearer", key));
        } catch (Exception ex) {
            log.warn(ERROR_MASSAGE, ex.getMessage(), ex);
            throw new ApiClientException(HttpStatus.INTERNAL_SERVER_ERROR, ex,
                    "Failed dummyApi get data");
        }
    }

    @Override
    public void store(String key, DummyApiRequest value) throws ApiClientException {
        try {
            dummyApiClient.storeDummyData("testBearer", key, value);
        } catch (Exception ex) {
            log.warn(ERROR_MASSAGE, ex.getMessage(), ex);
            throw new ApiClientException(HttpStatus.INTERNAL_SERVER_ERROR, ex,
                    "Failed dummyApi store data");
        }
    }

    @Override
    public void delete(String key) throws ApiClientException {
        try {
            dummyApiClient.deleteDummyData("testBearer", key);
        } catch (Exception ex) {
            log.warn(ERROR_MASSAGE, ex.getMessage(), ex);
            throw new ApiClientException(HttpStatus.INTERNAL_SERVER_ERROR, ex,
                    "Failed dummyApi store data");
        }
    }
}
