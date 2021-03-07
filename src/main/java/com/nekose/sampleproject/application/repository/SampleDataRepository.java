package com.nekose.sampleproject.application.repository;

import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;

import java.util.List;
import java.util.Optional;

public interface SampleDataRepository {
    Long store(SampleTableEntity entity);

    Long update(SampleTableEntity entity);

    void delete(Long id);

    void physicalDelete(Long id);

    Optional<SampleTableEntity> findById(Long id);

    List<SampleTableEntity> findByValueAndDeletedFlg(String value,
                                                     Boolean deletedFlg);
}
