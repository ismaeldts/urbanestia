package com.urbanestia.property.infrastructure.rest.api.dto.request;

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
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private String type;
    private Double latitude;
    private Double longitude;

}
