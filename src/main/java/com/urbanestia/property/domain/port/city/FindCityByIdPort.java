package com.urbanestia.property.domain.port.city;

import com.urbanestia.property.domain.model.CityModel;
import reactor.core.publisher.Mono;

public interface FindCityByIdPort {
    Mono<CityModel> findById(String id);

}
