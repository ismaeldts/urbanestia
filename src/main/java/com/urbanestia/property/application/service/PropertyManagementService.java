package com.urbanestia.property.application.service;

import com.urbanestia.property.domain.model.PropertyModel;
import com.urbanestia.property.domain.port.property.CreatePropertyPort;
import com.urbanestia.property.domain.port.property.FindPropertyPort;
import com.urbanestia.property.infrastructure.adapter.filter.criteria.PropertyCriteria;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class PropertyManagementService {

    private final CreatePropertyPort createPropertyPort;
    private final FindPropertyPort findPropertyPort;

    public Mono<PropertyModel> createProperty(PropertyModel propertyModel, String createdBy) {
        propertyModel.setOwnerId(createdBy);
        propertyModel.setPublicationDate(LocalDateTime.now());
        if (propertyModel.getDescriptionImages().size() > 1) {
            propertyModel.setStatus("WAITING_FOR_INFORMATION");
        }
        return createPropertyPort.createProperty(propertyModel);
    }

    public Flux<PropertyModel> findAllPropertiesByCriteria(PropertyCriteria criteria) {
        return findPropertyPort.findAllPropertiesByCriteria(criteria);
    }

    public Flux<PropertyModel> findAllProperties() {
        return findPropertyPort.findAllProperties();
    }

}
