package com.nekose.sampleproject.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "dummy-api")
public class DummyApiProperties {
    private String hostUrl;
    private String endpoint;
    private int readTimeout;
    private int connectTimeout;
    private int maxConnection;
    private int retryLimit;
}
