package com.urbanestia.property.domain.port.city;

import com.urbanestia.property.domain.model.CityModel;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreateCityPort {
    Mono<CityModel> createCity(CityModel cityModel);

    Flux<CityModel> createCities(List<CityModel> cityModel);
}
