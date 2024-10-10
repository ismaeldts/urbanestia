package com.urbanestia.property.infrastructure.adapter.entity;

import com.urbanestia.property.domain.model.CountryModel;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("properties")
public class PropertyEntity {

    @Id
    private String id;
    private String ownerId;
    private String title;
    private String description;
    private CountryEntity country;
    private String direction;
    private Integer guestCapacity;
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
