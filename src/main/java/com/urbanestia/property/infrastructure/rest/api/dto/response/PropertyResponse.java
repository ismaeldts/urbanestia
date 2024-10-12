package com.urbanestia.property.infrastructure.rest.api.dto.response;

import com.urbanestia.property.domain.model.CountryModel;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Data
public class PropertyResponse {
    private String id;
    private String ownerId;
    private String title;
    private String description;
    private Integer guestCapacity;
    private String postalCode;
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private Double price;
    private String imgUrl;
    private String type;
    private String status;
    private List<String> descriptionImages;
    private LocalDateTime publicationDate;
    private Double latitude;
    private Double longitude;
}
