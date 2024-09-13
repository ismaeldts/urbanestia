package com.urbanestia.property.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyModel {

    private String id;
    private String owner;
    private String title;
    private String description;
    private CountryModel countryModel;
    private Integer guestCapacity;
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private Double price;
    private String profileImg;
    private String status;
    private String type;
    private List<String> images;
    private LocalDateTime publicationDate;
    private Double latitude;
    private Double longitude;
}
