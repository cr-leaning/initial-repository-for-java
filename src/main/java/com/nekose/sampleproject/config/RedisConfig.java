// TODO Resolve about redis
//package com.nekose.sampleproject.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class RedisConfig {
//    @Profile({"local", "test", "it"})
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(RedisProperties redisProperties) {
//        var configuration = new RedisStandaloneConfiguration(redisProperties.getHost(), redisProperties.getPort());
//        return new JedisConnectionFactory(configuration, JedisClientConfiguration.defaultConfiguration());
//    }
//
//    @Profile({"prod"})
//    @Bean
//    public RedisConnectionFactory redisConnectionFactoryForRedisCluster(RedisProperties redisProperties) {
//        var configuration = new RedisClusterConfiguration();
//        configuration.clusterNode(redisProperties.getHost(), redisProperties.getPort());
//
//        var jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(redisProperties.getJedis().getPool().getMaxActive());
//
//        var jedisClientConfiguration = JedisClientConfiguration.builder()
//                .connectTimeout(redisProperties.getTimeout())
//                .readTimeout(redisProperties.getTimeout())
//                .usePooling()
//                .poolConfig(jedisPoolConfig)
//                .build();
//        return new JedisConnectionFactory(configuration, jedisClientConfiguration);
//    }
//
//    @Bean("sampleRedisTemplate")
//    public RedisTemplate sampleRedisTemplate(RedisConnectionFactory factory) {
//        final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setKeySerializer(RedisSerializer.string());
//        redisTemplate.setHashKeySerializer(RedisSerializer.string());
//        redisTemplate.setValueSerializer(RedisSerializer.java());
//        redisTemplate.setHashValueSerializer(RedisSerializer.java());
//        redisTemplate.setConnectionFactory(factory);
//        redisTemplate.setEnableTransactionSupport(true);
//        return redisTemplate;
//    }
//}
