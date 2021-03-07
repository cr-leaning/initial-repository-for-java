package com.nekose.sampleproject.infrastructure.rdb.entity;

import com.nekose.sampleproject.controller.request.SampleRequest;
import com.nekose.sampleproject.domain.model.entity.DataStatusInfo;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SampleTableEntity extends BaseEntity {
    private Long id;
    private String name;
    private String value;
    private DataStatusInfo dataStatusInfo;

    public static SampleTableEntity from(SampleRequest request) {
        return SampleTableEntity.builder()
                .name(request.getName())
                .value(request.getValue())
                .dataStatusInfo(request.getDataStatusInfo())
                .build();
    }

    public static SampleTableEntity from(Long id, SampleRequest request) {
        var entity = SampleTableEntity.from(request);
        entity.setId(id);
        return entity;
    }
}
