package com.nekose.sampleproject.config.property.sample;

import lombok.Data;

@Data
public class RedisProperties {
    private String prefix;
    private Long ttlSeconds;
}
