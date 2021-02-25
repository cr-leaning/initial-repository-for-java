package com.nekose.sampleproject.application.repository;

import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;

import java.util.List;

interface SampleTableRepository {
    void store(SampleTableEntity entity);

    void update(SampleTableEntity entity);

    void delete(Long id);

    void physicalDelete(SampleTableEntity entity);

    SampleTableEntity findById(Long id);

    List<SampleTableEntity> findByValueAndDeletedFlg(String value,
                                                     Boolean deletedFlg);
}
