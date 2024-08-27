package com.urbanestia.property.domain.port.country;

import com.urbanestia.property.domain.model.CountryModel;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface FindCountryByIdPort {
    Mono<CountryModel> findCountryById(UUID id);
}
