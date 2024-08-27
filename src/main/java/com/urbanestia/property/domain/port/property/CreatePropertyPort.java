package com.urbanestia.property.domain.port.property;

import com.urbanestia.property.domain.model.PropertyModel;
import reactor.core.publisher.Mono;

public interface CreatePropertyPort {

    Mono<PropertyModel> createProperty(PropertyModel propertyModel);
}
