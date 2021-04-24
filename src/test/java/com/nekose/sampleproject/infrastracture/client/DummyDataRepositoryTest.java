package com.nekose.sampleproject.infrastracture.client;

import com.nekose.sampleproject.application.repository.DummyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"local", "test"})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DummyDataRepositoryTest {
    @Autowired
    private DummyDataRepository dummyDataRepository;

}
