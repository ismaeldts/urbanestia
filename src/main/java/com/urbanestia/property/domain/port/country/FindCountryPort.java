package com.urbanestia.property.domain.port.country;

import com.urbanestia.property.domain.model.CountryModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FindCountryPort {
    Mono<CountryModel> findCountryById(String id);

    Flux<CountryModel> findAll();
}
