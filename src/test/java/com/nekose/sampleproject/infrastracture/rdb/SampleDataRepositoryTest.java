package com.nekose.sampleproject.infrastracture.rdb;

import com.nekose.sampleproject.application.repository.SampleDataRepository;
import com.nekose.sampleproject.config.DatasourceConfig;
import com.nekose.sampleproject.config.property.SampleProperties;
import com.nekose.sampleproject.infrastructure.rdb.SampleTableRepositoryImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@ActiveProfiles({"local", "test"})
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        DataSourceAutoConfiguration.class,
        DatasourceConfig.class,
        JdbcTemplateAutoConfiguration.class,
        SampleTableRepositoryImpl.class,
        SampleProperties.class
}, initializers = ConfigDataApplicationContextInitializer.class)
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class
})
@EnableConfigurationProperties
public class SampleDataRepositoryTest {
    @Autowired
    private SampleDataRepository sampleDataRepository;
}
