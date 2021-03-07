package com.nekose.sampleproject.application;

import com.nekose.sampleproject.application.repository.SampleDataRepository;
import com.nekose.sampleproject.application.service.SampleDataService;
import com.nekose.sampleproject.application.transaction.SampleTransaction;
import com.nekose.sampleproject.controller.request.SampleRequest;
import com.nekose.sampleproject.controller.request.SearchSampleRequest;
import com.nekose.sampleproject.domain.model.entity.SampleData;
import com.nekose.sampleproject.domain.model.entity.SearchSampleData;
import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleApplication {
    private final SampleDataRepository sampleDataRepository;
    private final SampleTransaction sampleTransaction;
    private final SampleDataService sampleDataService;

    public SampleData get(Long id) {
        return sampleDataRepository.findById(id)
                .map(entity -> sampleDataService.getSampleData(entity))
                .orElse(SampleData.builder().build());
    }

    public SearchSampleData search(SearchSampleRequest request) {
        return sampleDataService.getSearchSampleData(
                sampleDataRepository.findByValueAndDeletedFlg(request.getValue(), request.getDeleteFlg()));
    }

    public SampleData store(SampleRequest request) {
        return this.get(sampleTransaction.store(SampleTableEntity.from(request)));
    }

    public SampleData update(Long id, SampleRequest request) {
        return this.get(sampleTransaction.update(SampleTableEntity.from(id, request)));
    }

    public void delete(Long id) {
        sampleTransaction.delete(id);
    }

    public void physicalDelete(Long id) {
        sampleTransaction.physicalDelete(id);
    }
}
