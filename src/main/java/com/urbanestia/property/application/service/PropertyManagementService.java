package com.urbanestia.property.application.service;

import com.urbanestia.property.domain.model.PropertyModel;
import com.urbanestia.property.domain.port.property.CreatePropertyPort;
import com.urbanestia.property.domain.port.property.DeletePropertyByIdPort;
import com.urbanestia.property.domain.port.property.FindPropertyPort;
import com.urbanestia.property.domain.port.property.UpdatePropertyByIdPort;
import com.urbanestia.property.infrastructure.adapter.filter.criteria.PropertyCriteria;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class PropertyManagementService {

    private final CreatePropertyPort createPropertyPort;
    private final FindPropertyPort findPropertyPort;
    private final UpdatePropertyByIdPort updatePropertyPort;
    private final DeletePropertyByIdPort deletePropertyByIdPort;


    public Mono<PropertyModel> createProperty(PropertyModel propertyModel, String createdBy) {
        propertyModel.setOwnerId(createdBy);
        propertyModel.setPublicationDate(LocalDateTime.now());
        if (propertyModel.getDescriptionImages().isEmpty()) {
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

    public Flux<PropertyModel> findAllPropertiesByOwnerId(String ownerId) {
        return this.findPropertyPort.findAllByOwnerId(ownerId);
    }

    public Mono<Void> updateProperty(PropertyModel propertyModel, String id) {
        return updatePropertyPort.updatePropertyById(id, propertyModel);
    }

    public Mono<PropertyModel> findById(String propertyId){
        return findPropertyPort.findPropertyById(propertyId);
    }

    public Mono<Void> deletePropertyById(String propertyId){
        return deletePropertyByIdPort.deletePropertyById(propertyId);
    }

}
