package com.urbanestia.property.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("properties")
public class PropertyEntity {

    @Id
    private String id;
    private String owner;
    private String title;
    private String description;
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private Integer guestCapacity;
    private CountryEntity countryId;
    private String type;
    private LocalDateTime publicationDate;
    private LocalDateTime updatedDate;
    private String status;
    private Double price;
    private PropertyType propertyType;
    private Double latitude;
    private Double longitude;

}
