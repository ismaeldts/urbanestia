package com.urbanestia.property.domain.port.address;

import reactor.core.publisher.Mono;


public interface DeleteAddressByIdPort {
    Mono<Void> removeAddress(String id);

}
