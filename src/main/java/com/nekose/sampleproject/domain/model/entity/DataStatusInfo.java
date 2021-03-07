package com.nekose.sampleproject.domain.model.entity;

import com.nekose.sampleproject.constant.DataStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataStatusInfo {
    @NotNull
    private DataStatus status;
    private String information;
}
