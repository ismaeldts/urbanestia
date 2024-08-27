package com.urbanestia.property.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressModel {
    private UUID id;
    private String address;
    private CityModel cityModel;
    private String postalCode;
}
