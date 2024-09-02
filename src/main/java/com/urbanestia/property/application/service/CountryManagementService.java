package com.urbanestia.property.application.service;

import com.urbanestia.property.application.usecase.CountryUseCase;
import com.urbanestia.property.domain.model.CountryModel;
import com.urbanestia.property.domain.port.country.CreateCountryPort;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class CountryManagementService implements CountryUseCase {

    private final CreateCountryPort createCountryPort;

    @Override
    public Mono<CountryModel> createCountry(CountryModel countryModel) {
        return createCountryPort.createCountry(countryModel);
    }

}
