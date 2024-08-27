package com.urbanestia.property.domain.port.address;

import com.urbanestia.property.domain.model.AddressModel;
import reactor.core.publisher.Mono;

public interface CreateAddressPort {
    Mono<AddressModel> address(AddressModel addressModel);
}
