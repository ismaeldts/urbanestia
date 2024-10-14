package com.urbanestia.property.domain.port.city;

import com.urbanestia.property.domain.model.CityModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FindCityPort {
    Mono<CityModel> findById(String id);

    Flux<CityModel> findAllCitiesByCountryId(String id);
}
