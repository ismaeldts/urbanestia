package com.urbanestia.property.domain.port.property;

import com.urbanestia.property.domain.model.PropertyModel;
import com.urbanestia.property.infrastructure.adapter.filter.criteria.PropertyCriteria;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FindPropertyPort {

    Flux<PropertyModel> findAllPropertiesByCriteria(PropertyCriteria criteria);
    Flux<PropertyModel> findAllProperties( );


    Flux<PropertyModel> findAllByOwnerId(String ownerId);

    Mono<PropertyModel> findPropertyById(String id);

    Mono<Boolean> existsPropertyById(String ownerId);

}
