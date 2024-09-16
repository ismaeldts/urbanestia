package com.urbanestia.property.infrastructure.rest.api;

import com.urbanestia.property.application.service.PropertyManagementService;
import com.urbanestia.property.infrastructure.adapter.filter.criteria.PropertyCriteria;
import com.urbanestia.property.infrastructure.rest.api.dto.request.PropertyRequest;
import com.urbanestia.property.infrastructure.rest.api.dto.response.BaseEntityResponse;
import com.urbanestia.property.infrastructure.rest.api.dto.response.PropertyResponse;
import com.urbanestia.property.infrastructure.rest.api.dto.response.PropertyResponseDtoMapper;
import com.urbanestia.property.infrastructure.rest.mapper.request.PropertyRequestMapper;
import com.urbanestia.property.shared.SanitizeStringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/api/v1/properties")
@RequiredArgsConstructor
@Slf4j
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

    @GetMapping(path = "/findAll/filter")
    public Flux<PropertyResponse> findAllPropertiesByCriteria(
            @RequestParam(required = false) Integer maxNumberOfBathrooms,
            @RequestParam(required = false) Integer minNumberOfBathrooms,
            @RequestParam(required = false) Integer minNumberOfRooms,
            @RequestParam(required = false) Integer maxNumberOfRooms,
            @RequestParam(required = false) Integer maxGuestCapacity,
            @RequestParam(required = false) Integer minGuestCapacity
    ) {
        return propertyManagementService.findAllPropertiesByCriteria(
                PropertyCriteria.builder()
                        .maxNumberOfBathrooms(maxNumberOfBathrooms)
                        .minNumberOfBathrooms(minNumberOfBathrooms)
                        .minNumberOfRooms(minNumberOfRooms)
                        .maxNumberOfRooms(maxNumberOfRooms)
                        .maxGuestCapacity(maxGuestCapacity)
                        .minGuestCapacity(minGuestCapacity)
                        .build())
                .map(this.propertyDTOMapper::toDto);
    }

    @GetMapping(path = "/findAll")
    public Flux<PropertyResponse> findAllProperties() {
        return this.propertyManagementService.findAllProperties() // Asumiendo que devuelve Flux<PropertyModel>
                .map(this.propertyDTOMapper::toDto); // Aquí se mapea el PropertyModel a PropertyResponse
    }


}
