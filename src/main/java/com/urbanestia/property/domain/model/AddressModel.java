package com.urbanestia.property.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressModel {
    private String id;
    private String address;
    private CityModel cityModel;
    private String postalCode;
}
