package com.urbanestia.property.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityEntity {

    @Id
    private UUID id;
    private String name;
    private CountryEntity country;

}
