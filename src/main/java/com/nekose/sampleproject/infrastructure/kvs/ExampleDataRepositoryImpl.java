package com.nekose.sampleproject.infrastructure.kvs;

import com.nekose.sampleproject.application.repository.ExampleDataRepository;
import com.nekose.sampleproject.config.property.SampleProperties;
import com.nekose.sampleproject.config.property.sample.RedisProperties;
import com.nekose.sampleproject.infrastructure.kvs.dto.ExampleDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Repository
public class ExampleDataRepositoryImpl implements ExampleDataRepository {
    private final RedisTemplate<String, Object> sampleRedisTemplate;
    private final RedisProperties redis;

    public ExampleDataRepositoryImpl(@Qualifier("sampleRedisTemplate") RedisTemplate<String, Object> sampleRedisTemplate,
                                     SampleProperties sampleProperties) {
        this.sampleRedisTemplate = sampleRedisTemplate;
        this.redis = sampleProperties.getRedis();
    }

    @Override
    public Optional<ExampleDto> get(String key) {
        return Optional.ofNullable(sampleRedisTemplate.opsForValue().get(generateKey(key)))
                .map(ExampleDto.class::cast);
    }

    @Override
    public void store(String key, ExampleDto value) {
        sampleRedisTemplate.opsForValue().set(generateKey(key), value, Duration.ofSeconds(redis.getTtlSeconds()));
    }

    @Override
    public void delete(String key) {
        sampleRedisTemplate.delete(generateKey(key));
    }

    private String generateKey(String key) {
        return redis.getPrefix() + DateTimeFormatter.ofPattern("yyyyMMddhhmmssxxxz").format(Instant.now()) + key;
    }
}
