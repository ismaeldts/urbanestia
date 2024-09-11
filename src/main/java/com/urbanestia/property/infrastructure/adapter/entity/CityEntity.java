package com.urbanestia.property.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("cities")
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
