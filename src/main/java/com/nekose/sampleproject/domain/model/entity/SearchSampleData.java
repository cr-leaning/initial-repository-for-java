package com.nekose.sampleproject.domain.model.entity;

import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class SearchSampleData {
    private List<SampleData> samples;

    public static SearchSampleData from(List<SampleTableEntity> entities) {
        return SearchSampleData.builder()
                .samples(entities.stream()
                        .map(entity ->  SampleData.from(entity))
                        .collect(Collectors.toList()))
                .build();
    }
}
