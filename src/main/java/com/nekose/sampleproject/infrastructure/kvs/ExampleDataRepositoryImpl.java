// TODO Resolve
package com.nekose.sampleproject.infrastructure.kvs;
//

import com.nekose.sampleproject.application.repository.ExampleDataRepository;
import com.nekose.sampleproject.infrastructure.kvs.dto.ExampleDto;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//
@Repository
public class ExampleDataRepositoryImpl implements ExampleDataRepository {
//    private final RedisTemplate<String, Object> sampleRedisTemplate;
//    private final RedisProperties redis;
//
//    public ExampleDataRepositoryImpl(@Qualifier("sampleRedisTemplate") RedisTemplate<String, Object> sampleRedisTemplate,
//                                     SampleProperties sampleProperties) {
//        this.sampleRedisTemplate = sampleRedisTemplate;
//        this.redis = sampleProperties.getRedis();
//    }
//
    @Override
    public Optional<ExampleDto> get(String key) {
//        return Optional.ofNullable(sampleRedisTemplate.opsForValue().get(generateKey(key)))
//                .map(ExampleDto.class::cast);
        throw new NotImplementedException();
    }
//
    @Override
    public void store(String key, ExampleDto value) {
//        sampleRedisTemplate.opsForValue().set(generateKey(key), value, Duration.ofSeconds(redis.getTtlSeconds()));
        throw new NotImplementedException();
    }
//
    @Override
    public void delete(String key) {
//        sampleRedisTemplate.delete(generateKey(key));
        throw new NotImplementedException();
    }
//
//    private String generateKey(String key) {
//        return redis.getPrefix() + key;
//    }
}
