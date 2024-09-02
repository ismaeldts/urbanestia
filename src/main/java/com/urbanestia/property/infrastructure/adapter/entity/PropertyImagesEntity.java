package com.urbanestia.property.infrastructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyImagesEntity {

    @Id
    private Long id;
    private String url;
    private String status;
    private String uploadedDate;
    private String uploadedBy;
}
