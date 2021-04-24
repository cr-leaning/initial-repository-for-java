package com.nekose.sampleproject.infrastructure.client;

import com.nekose.sampleproject.application.repository.DummyDataRepository;
import com.nekose.sampleproject.config.property.SampleProperties;
import com.nekose.sampleproject.exception.ApiClientException;
import com.nekose.sampleproject.infrastructure.client.feign.DummyApiClient;
import com.nekose.sampleproject.infrastructure.client.request.DummyApiRequest;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiResponse;
import com.nekose.sampleproject.util.StringCryptoConverter;
import feign.FeignException;
import feign.RetryableException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ConnectTimeoutException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.net.SocketTimeoutException;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DummyDataRepositoryImpl implements DummyDataRepository {
    private final DummyApiClient dummyApiClient;
    private final SampleProperties sampleProperties;
    private final StringCryptoConverter stringCryptoConverter;


    @Override
    public Optional<DummyApiResponse> get(String key) {
        int retryLimit = sampleProperties.getDummyApi().getRetryLimit();
        String message = null;
        for (int i = 0; i < retryLimit; i++) {
            try {
                return Optional.ofNullable(dummyApiClient.getDummyData("testBearer", key));
            } catch (RetryableException re) {
                log.warn("RetryableException: {}", re.getMessage(), re);
                if (!(re.getCause() instanceof ConnectTimeoutException
                        || re.getCause() instanceof SocketTimeoutException)) {
                    break;
                }
                message = re.getMessage();
            } catch (FeignException fe) {
                log.warn("FeignException: {}", fe.getMessage(), fe);
                message = fe.getMessage();
                break;
            } catch (Exception ex) {
                log.warn("Unexpected Exception: {}", ex.getMessage(), ex);
                message = ex.getMessage();
                break;
            }
        }
        throw new ApiClientException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Failed dummyApi get data", message);
    }

    @Override
    public void store(String key, DummyApiRequest value) {
        try {
            dummyApiClient.storeDummyData("testBearer", key, value);
        } catch (Exception ex) {
            log.warn("Unexpected Exception: {}", ex.getMessage(), ex);
            throw new ApiClientException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Failed dummyApi store data", ex.getMessage());
        }
    }

    @Override
    public void delete(String key) {
        try {
            dummyApiClient.deleteDummyData("testBearer", key);
        } catch (Exception ex) {
            log.warn("Unexpected Exception: {}", ex.getMessage(), ex);
            throw new ApiClientException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Failed dummyApi store data", ex.getMessage());
        }
    }
}
