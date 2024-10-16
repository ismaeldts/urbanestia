package com.urbanestia.property.infrastructure.rest.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryResponse {
    private String id;
    private String name;
    private String code;
}
