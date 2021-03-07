package com.nekose.sampleproject.application.service;

import com.nekose.sampleproject.domain.model.entity.SampleData;
import com.nekose.sampleproject.domain.model.entity.SearchSampleData;
import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;

import java.util.List;

public interface SampleDataService {
    SampleData getSampleData(SampleTableEntity entity);

    SearchSampleData getSearchSampleData(List<SampleTableEntity> entities);
}
