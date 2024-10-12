package com.urbanestia.property.domain.port.property;

import reactor.core.publisher.Mono;

public interface DeletePropertyByIdPort {

  Mono<Void> deletePropertyById(String id);

}
