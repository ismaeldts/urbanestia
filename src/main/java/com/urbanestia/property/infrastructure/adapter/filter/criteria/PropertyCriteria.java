package com.urbanestia.property.infrastructure.adapter.filter.criteria;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PropertyCriteria {
    private Integer minGuestCapacity;
    private Integer maxGuestCapacity;
    private Integer minNumberOfRooms;
    private Integer maxNumberOfRooms;
    private Integer minNumberOfBathrooms;
    private Integer maxNumberOfBathrooms;
}
