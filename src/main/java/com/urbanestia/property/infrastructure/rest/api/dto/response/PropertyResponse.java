package com.urbanestia.property.infrastructure.rest.api.dto.response;

import com.urbanestia.property.domain.model.CountryModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Data
public class PropertyResponse {
    private String id;
    private String owner;
    private String title;
    private String description;
    private String imgUrl;
    private CountryModel countryModel;
    private Integer guestCapacity;
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private String type;
    private LocalDateTime publicationDate;
    private Double latitude;
    private Double longitude;
}
