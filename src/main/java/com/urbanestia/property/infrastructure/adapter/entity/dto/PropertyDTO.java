package com.urbanestia.property.infrastructure.adapter.entity.dto;

import com.urbanestia.property.domain.model.CountryModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private Long id;
    private String owner;
    private String title;
    private String description;
    private CountryModel countryModel;
    private Integer guestCapacity;
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private String type;
    private LocalDateTime publicationDate;
}
