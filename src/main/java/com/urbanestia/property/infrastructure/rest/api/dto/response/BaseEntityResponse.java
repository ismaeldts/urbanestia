package com.urbanestia.property.infrastructure.rest.api.dto.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntityResponse {
    private String code;
    private String message;
    private LocalDateTime time;
}
