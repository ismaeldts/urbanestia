package com.urbanestia.property.application.usecase;

import com.urbanestia.property.domain.model.CountryModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CountryUseCase {
    Mono<CountryModel> createCountry(CountryModel countryModel);

    Flux<CountryModel> findAll();

    Mono<CountryModel> findCountryById(String countryId);
}
