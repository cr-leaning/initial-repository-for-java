package com.nekose.sampleproject.config.property;

import com.nekose.sampleproject.config.property.sample.CryptoProperties;
import com.nekose.sampleproject.config.property.sample.RedisProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "sample-project")
public class SampleProperties {
    private RedisProperties redis;
//    private DummyApiProperties dummyApi;
    private CryptoProperties crypto;
}
