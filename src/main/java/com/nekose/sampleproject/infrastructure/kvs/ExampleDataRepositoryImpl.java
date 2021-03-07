package com.nekose.sampleproject.infrastructure.kvs;

import com.nekose.sampleproject.application.repository.ExampleDataRepository;
import com.nekose.sampleproject.config.property.sample.RedisProperties;
import com.nekose.sampleproject.infrastructure.kvs.dto.ExampleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ExampleDataRepositoryImpl implements ExampleDataRepository {
    private final RedisTemplate<String, Object> sampleRedisTemplate;
    private final RedisProperties redis;

    @Override
    public Optional<ExampleDto> get(String key) {
        return Optional.ofNullable(sampleRedisTemplate.opsForValue().get(key))
                .map(ExampleDto.class::cast);
    }

    @Override
    public void store(String key, ExampleDto value) {
        sampleRedisTemplate.opsForValue().set(key, value, Duration.ofSeconds(redis.getTtlSeconds()));
    }

    @Override
    public void delete(String key) {
        sampleRedisTemplate.delete(key);
    }
}
