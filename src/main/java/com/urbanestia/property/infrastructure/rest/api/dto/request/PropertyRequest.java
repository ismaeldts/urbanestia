package com.urbanestia.property.infrastructure.rest.api.dto.request;

import com.urbanestia.property.domain.model.CountryModel;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyRequest {

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
    private List<String> descriptionImages;
    private LocalDateTime publicationDate;
    private Double latitude;
    private Double longitude;
    private Double sizeInSquareMeters;
    private String condition;
    private String cityId;
}
