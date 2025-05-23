package com.urbanestia.property.infrastructure.rest.api;

import com.urbanestia.property.application.service.PropertyManagementService;
import com.urbanestia.property.infrastructure.adapter.filter.criteria.PropertyCriteria;
import com.urbanestia.property.infrastructure.rest.api.dto.request.PropertyRequest;
import com.urbanestia.property.infrastructure.rest.api.dto.response.BaseEntityResponse;
import com.urbanestia.property.infrastructure.rest.api.dto.response.PropertyResponse;
import com.urbanestia.property.infrastructure.rest.api.dto.response.PropertyResponseDtoMapper;
import com.urbanestia.property.infrastructure.rest.mapper.request.PropertyRequestMapper;
import com.urbanestia.property.shared.SanitizeStringUtil;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
        log.info("Entrando la petición de crear propiedades.");
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

    @GetMapping(path = "/findAllByOwner/{ownerId}")
    public Mono<ResponseEntity<Flux<PropertyResponse>>> findAllByOwner(
        @PathVariable("ownerId") String ownerId) {

        Flux<PropertyResponse> properties = propertyManagementService
            .findAllPropertiesByOwnerId(ownerId)
            .map(this.propertyDTOMapper::toDto);

        return properties
            .hasElements()
            .flatMap(hasElements -> {
                if (hasElements) {
                    return Mono.just(new ResponseEntity<>(properties, HttpStatus.OK));
                } else {
                    return Mono.just(new ResponseEntity<>(Flux.empty(), HttpStatus.NO_CONTENT));
                }
            });
    }

    @PutMapping(path = "/updateProperty/{id}")
    public Mono<ResponseEntity<BaseEntityResponse>> updatePropertyById(
        @RequestBody PropertyRequest propertyRequest, @PathVariable("id") String id) {
        return Mono.just(this.propertyRequestMapper.toEntity(propertyRequest)).flatMap(
                propertyModel -> this.propertyManagementService.updateProperty(propertyModel, id))
            .then(Mono.just(ResponseEntity.status(200).body(
                new BaseEntityResponse("200", "La propiedad fue actualizada con exito.",
                    LocalDateTime.now()))));
    }

    /**
     * Retrieves a property by its unique identifier.
     *
     * @param propertyId The unique identifier of the property to be retrieved.
     * @return A {@link Mono} containing the {@link PropertyResponse} of the found property.
     *         If no property is found with the given {@code propertyId}, the {@link Mono} will complete empty.
     *
     * @throws IllegalArgumentException If the {@code propertyId} is null or empty.
     */
    @GetMapping(path = "/findById/{propertyId}")
    public Mono<PropertyResponse> findById(@PathVariable("propertyId") String propertyId) {
        return propertyManagementService.findById(propertyId).map(this.propertyDTOMapper::toDto);
    }

    /**
     * Deletes a property by its unique identifier.
     *
     * @param propertyId The unique identifier of the property to be deleted.
     * @return A {@link Mono} containing a {@link ResponseEntity} with a {@link BaseEntityResponse} indicating the success of the deletion operation.
     *         If the property with the given {@code propertyId} does not exist, the {@link Mono} will complete empty.
     *
     * @throws IllegalArgumentException If the {@code propertyId} is null or empty.
     */
    @DeleteMapping(path = "/deleteById/{propertyId}")
    public Mono<ResponseEntity<BaseEntityResponse>> deleteById(
        @PathVariable("propertyId") String propertyId) {
        return propertyManagementService.deletePropertyById(propertyId)
            .then(Mono.just(ResponseEntity.status(200).body(
                new BaseEntityResponse("200", "La propiedad fue eliminada con exito.",
                    LocalDateTime.now()))));
    }

    @GetMapping(path = "/existsById/{propertyId}")
    public Mono<Boolean> existsPropertyById(@PathVariable("propertyId") String propertyId) {
        return this.propertyManagementService.existsPropertyById(propertyId);
    }
}
