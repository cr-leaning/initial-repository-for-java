package com.nekose.sampleproject.infrastructure.client;

import com.nekose.sampleproject.infrastructure.client.config.DummyApiResponseExceptionMapper;
import com.nekose.sampleproject.infrastructure.client.request.DummyApiRequest;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiResponse;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiTokenResponse;
import org.apache.http.conn.ConnectTimeoutException;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.SocketTimeoutException;

@RegisterRestClient(configKey="dummy-api")
@RegisterProvider(DummyApiResponseExceptionMapper.class)
public interface DummyApiClient {
    @GetMapping(value = "${dummy-api.token-endpoint}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Retry(
            retryOn = {ConnectTimeoutException.class, SocketTimeoutException.class},
            maxRetries = 3
    )
    // @Fallback(fallbackMethod = "fallbackMethod")
    DummyApiTokenResponse getAccessToken(@RequestHeader("Authorization") String basicToken,
                                         MultiValueMap<String, String> accessTokenParams);

    @GetMapping(value = "${dummy-api.endpoint}", consumes = MediaType.APPLICATION_JSON_VALUE)
    DummyApiResponse getDummyData(@RequestHeader("Authorization") String bearerToken,
                                  @PathVariable("id") String id);

    @PutMapping(value = "${dummy-api.endpoint}", consumes = MediaType.APPLICATION_JSON_VALUE)
    DummyApiResponse storeDummyData(@RequestHeader("Authorization") String bearerToken,
                                    @PathVariable("id") String id,
                                    @RequestBody DummyApiRequest request);

    @DeleteMapping(value = "${dummy-api.endpoint}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteDummyData(@RequestHeader("Authorization") String bearerToken,
                         @PathVariable("id") String id);
}
