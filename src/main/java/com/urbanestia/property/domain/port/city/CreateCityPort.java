package com.urbanestia.property.domain.port.city;

import com.urbanestia.property.domain.model.CityModel;
import reactor.core.publisher.Mono;

public interface CreateCityPort {
    Mono<CityModel> createCity(CityModel cityModel);
}
