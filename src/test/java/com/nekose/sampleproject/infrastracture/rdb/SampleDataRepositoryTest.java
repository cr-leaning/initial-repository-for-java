package com.nekose.sampleproject.infrastracture.rdb;

import com.nekose.sampleproject.application.repository.SampleDataRepository;
import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class SampleDataRepositoryTest {
    @Autowired
    private SampleDataRepository sampleDataRepository;

    @Test
    void storeAndGet() {
        var expected = SampleTableEntity.builder()
                .name("testName")
                .value("testValue")
                .build();

        var id = sampleDataRepository.store(expected);
        var actual = sampleDataRepository.getById(id);

        assertTrue(actual.isPresent());
        assertAll(
                () -> {
                    var actualEntity = actual.get();

                    assertAll(
                            () -> assertEquals(expected.getName(), actualEntity.getName()),
                            () -> assertEquals(expected.getValue(), actualEntity.getValue())
                    );
                }
        );
    }
}