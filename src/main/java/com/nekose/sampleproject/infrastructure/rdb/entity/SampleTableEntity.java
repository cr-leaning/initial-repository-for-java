package com.nekose.sampleproject.infrastructure.rdb.entity;

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
}
