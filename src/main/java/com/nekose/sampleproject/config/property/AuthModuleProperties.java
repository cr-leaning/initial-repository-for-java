package com.nekose.sampleproject.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "auth-module")
public class AuthModuleProperties {
    private String tokenUrl;
    private String clientId;
    private String clientSecret;
}
