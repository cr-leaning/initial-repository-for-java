package com.nekose.sampleproject.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ExampleRequest {
    @NotBlank
    @Size(max=20)
    @JsonProperty("key")
    private String key;

    @NotBlank
    @Size(max=20)
    @JsonProperty("name")
    private String name;

    @Size(max=20)
    @JsonProperty("value")
    private String value;
}
