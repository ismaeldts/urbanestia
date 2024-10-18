package com.urbanestia.property.domain.port.country;

import com.urbanestia.property.domain.model.CountryModel;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreateCountryPort {
    Mono<CountryModel> createCountry(CountryModel countryModel);

  Flux<CountryModel> createAll(List<CountryModel> countryModel);
}
