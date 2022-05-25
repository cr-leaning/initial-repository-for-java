package com.nekose.sampleproject.application.transaction;

import com.nekose.sampleproject.application.repository.SampleDataRepository;
import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SampleTransaction {
    private final SampleDataRepository sampleDataRepository;

    @Transactional(rollbackOn = Exception.class)
    public Long store(SampleTableEntity entity) {
        return sampleDataRepository.store(entity);
    }

    @Transactional(rollbackOn = Exception.class)
    public Long update(SampleTableEntity entity) {
        return sampleDataRepository.update(entity);
    }

    @Transactional(rollbackOn = Exception.class)
    public void delete(Long id) {
        sampleDataRepository.delete(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public void physicalDelete(Long id) {
        sampleDataRepository.physicalDelete(id);
    }
}
