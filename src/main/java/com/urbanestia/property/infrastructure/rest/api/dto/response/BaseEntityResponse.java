package com.urbanestia.property.infrastructure.rest.api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class BaseEntityResponse {
    private String code;
    private String message;
    private LocalDateTime time;
}
