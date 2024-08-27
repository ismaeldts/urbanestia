package com.urbanestia.property.infrastructure.rest.api;

import com.urbanestia.property.application.service.property.PropertyManagementService;
import com.urbanestia.property.infrastructure.adapter.entity.dto.PropertyDTO;
import com.urbanestia.property.infrastructure.adapter.filter.criteria.PropertyCriteria;
import com.urbanestia.property.infrastructure.rest.api.dto.request.PropertyRequest;
import com.urbanestia.property.infrastructure.rest.api.dto.response.BaseEntityResponse;
import com.urbanestia.property.infrastructure.rest.api.dto.response.PropertyResponseDtoMapper;
import com.urbanestia.property.infrastructure.rest.mapper.request.PropertyRequestMapper;
import com.urbanestia.property.shared.SanitizeStringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/api/v1/")
@RequiredArgsConstructor
public class PropertyController {

    private final PropertyManagementService propertyManagementService;
    private final PropertyRequestMapper propertyRequestMapper;
    private final PropertyResponseDtoMapper propertyDTOMapper;
    @PostMapping
    public Mono<ResponseEntity<BaseEntityResponse>> createProperty(@RequestBody PropertyRequest propertyRequest, @RequestHeader(name = "created_by") String createdBy) {
        return Mono.just(this.propertyRequestMapper.toEntity(propertyRequest))
                .flatMap(propertyModel -> this.propertyManagementService.createProperty(propertyModel, SanitizeStringUtil.sanitize(createdBy)))
                .then(Mono.just(ResponseEntity.status(HttpStatus.OK)
                        .body(BaseEntityResponse.builder()
                                .message("La propiedad ha sido creada exitosamente.")
                                .code("201")
                                .time(LocalDateTime.now())
                                .build())));
    }

    @GetMapping
    public Mono<ResponseEntity<PropertyDTO>> findAllPropertiesByCriteria(PropertyCriteria criteria) {
        return null;
    }
}
