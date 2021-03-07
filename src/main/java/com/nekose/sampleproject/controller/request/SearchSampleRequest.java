package com.nekose.sampleproject.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.AssertFalse;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SearchSampleRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("value")
    private String value;

    @JsonProperty("deleteFlg")
    private Boolean deleteFlg;

    @AssertFalse
    public boolean isValid() {
        return StringUtils.isAllBlank(name, value) && deleteFlg == null;
    }

}
