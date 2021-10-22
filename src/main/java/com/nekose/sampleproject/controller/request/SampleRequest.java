package com.nekose.sampleproject.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nekose.sampleproject.domain.model.entity.DataStatusInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SampleRequest {
    @NotBlank
    @Size(max=20)
    @JsonProperty("name")
    private String name;

    @Size(max=20)
    @JsonProperty("value")
    private String value;

    @Valid
    private DataStatusInfo dataStatusInfo;
}
