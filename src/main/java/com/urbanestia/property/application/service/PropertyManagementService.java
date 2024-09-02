package com.urbanestia.property.application.service;

import com.urbanestia.property.domain.model.PropertyModel;
import com.urbanestia.property.domain.port.property.CreatePropertyPort;
import com.urbanestia.property.domain.port.property.FindPropertyPort;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
public class PropertyManagementService {

    private final CreatePropertyPort createPropertyPort;
    private final FindPropertyPort findPropertyPort;

    public Mono<PropertyModel> createProperty(PropertyModel propertyModel, String createdBy) {
        propertyModel.setOwner(createdBy);
        propertyModel.setPublicationDate(LocalDateTime.now());
        return createPropertyPort.createProperty(propertyModel);
    }

    public Flux<PropertyModel> findById(UUID id) {
        return findPropertyPort.findAllPropertiesByOwner(id.toString());
    }
    public Flux<PropertyModel> findAllProperties() {
        return findPropertyPort.findAllProperties();
    }

}
