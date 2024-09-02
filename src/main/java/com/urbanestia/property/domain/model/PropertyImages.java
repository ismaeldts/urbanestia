package com.urbanestia.property.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyImages {

    private Long id;
    private String url;
    private String status;
    private String uploadedDate;
    private String uploadedBy;


}
