package com.urbanestia.property.domain.port.address;

import reactor.core.publisher.Mono;

import java.util.UUID;

public interface DeleteAddressByIdPort {
    Mono<Void> removeAddress(UUID id);

}
