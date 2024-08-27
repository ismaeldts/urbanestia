package com.urbanestia.property.domain.port.address;

import com.urbanestia.property.domain.model.AddressModel;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UpdateAddressByIdPort {
    Mono<AddressModel> updateAddressById(UUID id);

}
