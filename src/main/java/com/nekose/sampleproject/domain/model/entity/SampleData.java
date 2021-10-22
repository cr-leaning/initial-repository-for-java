package com.nekose.sampleproject.domain.model.entity;

import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
import com.nekose.sampleproject.util.DateUtils;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SampleData {
    private Long id;
    private String name;
    private String value;
    private DataStatusInfo dataStatusInfo;
    private String createDate;
    private String updateDate;

    public static SampleData from(SampleTableEntity entity) {
        return SampleData.builder()
                .id(entity.getId())
                .name(entity.getName())
                .value(entity.getValue())
                .dataStatusInfo(DataStatusInfo.builder()
                        .status(entity.getStatus())
                        .information(entity.getInformation())
                        .build())
                .createDate(DateUtils.toIsoFormatString(entity.getCreateDate()))
                .updateDate(DateUtils.toIsoFormatString(entity.getUpdateDate()))
                .build();
    }
}
