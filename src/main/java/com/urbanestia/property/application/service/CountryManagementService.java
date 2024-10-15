package com.urbanestia.property.application.service;

import com.urbanestia.property.application.usecase.CountryUseCase;
import com.urbanestia.property.domain.model.CountryModel;
import com.urbanestia.property.domain.port.country.CreateCountryPort;
import com.urbanestia.property.domain.port.country.FindCountryPort;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class CountryManagementService implements CountryUseCase {

    private final CreateCountryPort createCountryPort;
    private final FindCountryPort findCountryPort;

    @Override
    public Mono<CountryModel> createCountry(CountryModel countryModel) {
        return createCountryPort.createCountry(countryModel);
    }

    @Override
    public Mono<CountryModel> findCountryById(String countryId) {
        return findCountryPort.findCountryById(countryId);
    }

    public Flux<CountryModel> findAll() {
        return this.findCountryPort.findAll();
    }

}
