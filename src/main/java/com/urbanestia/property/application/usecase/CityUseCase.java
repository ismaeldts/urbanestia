package com.urbanestia.property.application.usecase;

import com.urbanestia.property.domain.model.CityModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CityUseCase {

    Mono<CityModel> createCity(CityModel cityModel);
    Mono<CityModel> findById(String cityId);
    Flux<CityModel> findAll();


}
