package com.urbanestia.property.domain.port.city;

import com.urbanestia.property.domain.model.CityModel;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface FindCityByIdPort {
    Mono<CityModel> findById(UUID id);

}
