package com.nekose.sampleproject.domain.service;

import com.nekose.sampleproject.application.service.SampleDataService;
import com.nekose.sampleproject.domain.model.entity.SampleData;
import com.nekose.sampleproject.domain.model.entity.SearchSampleData;
import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleDataServiceImpl implements SampleDataService {
    @Override
    public SampleData getSampleData(SampleTableEntity entity) {
        return SampleData.from(entity);
    }

    @Override
    public SearchSampleData getSearchSampleData(List<SampleTableEntity> entities) {
        return SearchSampleData.from(entities);
    }
}
