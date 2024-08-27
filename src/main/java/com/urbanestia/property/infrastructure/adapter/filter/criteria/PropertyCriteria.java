package com.urbanestia.property.infrastructure.adapter.filter.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyCriteria {
    private Integer minGuestCapacity;
    private Integer maxGuestCapacity;
    private Integer minNumberOfRooms;
    private Integer maxNumberOfRooms;
    private Integer minNumberOfBathrooms;
    private Integer maxNumberOfBathrooms;
}
