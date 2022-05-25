package com.nekose.sampleproject.infrastracture.client;

import com.nekose.sampleproject.application.repository.DummyDataRepository;
import io.quarkus.test.junit.QuarkusTest;
import org.springframework.beans.factory.annotation.Autowired;

@QuarkusTest
//@QuarkusTestResource(WiremockCountries.class)
class DummyDataRepositoryTest {
    @Autowired
    private DummyDataRepository dummyDataRepository;

}
