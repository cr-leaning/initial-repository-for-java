package com.nekose.sampleproject.controller.response;

import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SampleResponse extends BaseResponse {
    private SampleTableEntity entity;
}
