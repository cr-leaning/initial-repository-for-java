package com.nekose.sampleproject.infrastructure.client.config;

import com.nekose.sampleproject.config.property.SampleProperties;
import com.nekose.sampleproject.exception.ApiClientException;
import feign.Client;
import feign.Request;
import feign.Response;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.httpclient.ApacheHttpClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.FormHttpMessageConverter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static feign.FeignException.errorStatus;

@Slf4j
@RequiredArgsConstructor
public class DummyApiClientConfig {
    private final SampleProperties sampleProperties;
    private final ObjectFactory<HttpMessageConverters> messageConvertersObjectFactory;

    @Bean
    public Client getDummyApiTokenClient() {
        var apiProperties = sampleProperties.getDummyApi();
        var requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(apiProperties.getConnectTimeout())
                .setConnectTimeout(apiProperties.getConnectTimeout())
                .setSocketTimeout(apiProperties.getReadTimeout())
                .build();
        return new ApacheHttpClient(HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setMaxConnTotal(apiProperties.getMaxConnection())
                .setMaxConnPerRoute(apiProperties.getMaxConnection())
                .build());
    }

    @Bean
    public Request.Options getDummyApiTokenClientOptions() {
        var apiProperties = sampleProperties.getDummyApi();
        return new Request.Options(apiProperties.getConnectTimeout(), TimeUnit.MILLISECONDS,
                apiProperties.getReadTimeout(), TimeUnit.MILLISECONDS, true);
    }

    @Bean
    public Encoder feignEncoder() {
        return new SpringEncoder(() -> new HttpMessageConverters((new FormHttpMessageConverter())));
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return (String methodKey, Response response) -> {
            try {
                var decoder = new SpringDecoder(this.messageConvertersObjectFactory);
                String errorResponse = (String) decoder.decode(response, String.class);
                log.warn("error response status:{}, reason:{}, errorResponse:{}",
                        response.status(), response.reason(), errorResponse);
                return new ApiClientException(response.status(), response.reason(), errorResponse);
            } catch (IOException ioe) {
                return errorStatus(methodKey, response);
            }
        };
    }
}
