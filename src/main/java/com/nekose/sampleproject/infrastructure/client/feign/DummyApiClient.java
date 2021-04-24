package com.nekose.sampleproject.infrastructure.client.feign;

import com.nekose.sampleproject.infrastructure.client.config.DummyApiClientConfig;
import com.nekose.sampleproject.infrastructure.client.request.DummyApiRequest;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiResponse;
import com.nekose.sampleproject.infrastructure.client.response.DummyApiTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "dummy-api",
        url = "${dummy-api.host-url}",
        configuration = DummyApiClientConfig.class
)
public interface DummyApiClient {
    @GetMapping(value = "${dummy-api.token-endpoint}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
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
