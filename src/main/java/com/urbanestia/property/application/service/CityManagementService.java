package com.urbanestia.property.application.service;

import com.urbanestia.property.application.usecase.CityUseCase;
import com.urbanestia.property.domain.model.CityModel;
import com.urbanestia.property.domain.port.city.CreateCityPort;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class CityManagementService implements CityUseCase {

    private final CreateCityPort createCityPort;

    @Override
    public Mono<CityModel> createCity(CityModel cityModel) {
        return createCityPort.createCity(cityModel);
    }

    @Override
    public Mono<CityModel> findById(String cityId) {
        return null;
    }

    @Override
    public Flux<CityModel> findAll() {
        return null;
    }
}
