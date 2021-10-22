// TODO Resolve redis client
//package com.nekose.sampleproject.infrastracture.kvs;
//
//import com.nekose.sampleproject.application.repository.ExampleDataRepository;
//import com.nekose.sampleproject.config.RedisConfig;
//import com.nekose.sampleproject.config.property.SampleProperties;
//import com.nekose.sampleproject.infrastructure.kvs.ExampleDataRepositoryImpl;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ActiveProfiles({"local", "test"})
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {
//        ExampleDataRepositoryImpl.class,
//        RedisConfig.class,
//        SampleProperties.class
//}, initializers = ConfigDataApplicationContextInitializer.class)
//@EnableConfigurationProperties
//class ExampleDataRepositoryTest {
//    @Autowired
//    @Qualifier("sampleRedisTemplate")
//    private RedisTemplate sampleRedisTemplate;
//
//    @Autowired
//    private ExampleDataRepository exampleDataRepository;
//}
