package com.urbanestia.property.infrastructure.adapter.entity;

import com.urbanestia.property.domain.model.CountryModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "properties")
public class PropertyEntity {

    @Id
    private Long id;
    private String owner;
    private String title;
    private String description;
    private Integer numberOfRooms;
    private Integer numberOfBathrooms;
    private String type;
    private LocalDateTime publicationDate;
    private LocalDateTime updatedDate;
    private String status;
    private Double price;
    private PropertyType propertyType;

}
