package com.urbanestia.property.infrastructure.adapter.dao;

import com.urbanestia.property.domain.model.CityModel;
import com.urbanestia.property.domain.port.city.CreateCityPort;
import com.urbanestia.property.domain.port.city.FindCityPort;
import com.urbanestia.property.infrastructure.adapter.entity.mapper.CityEntityMapper;
import com.urbanestia.property.infrastructure.adapter.repository.CityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class CityBdDao implements CreateCityPort, FindCityPort {

    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    @Override
    public Mono<CityModel> createCity(CityModel cityModel) {
        return cityRepository.save(cityEntityMapper.toDto(cityModel))
                .map(this.cityEntityMapper::toEntity);
    }

    @Override
    public Flux<CityModel> createCities(List<CityModel> cityModel) {
        log.info("Entro petición al repository");
        return this.cityRepository.saveAll(cityEntityMapper.toDto(cityModel))
            .map(this.cityEntityMapper::toEntity)
            .switchIfEmpty(
                Mono.error(() -> new RuntimeException("The list of cities can not be empty")));
    }

    @Override
    public Mono<CityModel> findById(String id) {
        return this.cityRepository.findById(id).map(this.cityEntityMapper::toEntity).switchIfEmpty(
            Mono.error(() -> new RuntimeException("There's no city with this id")));
    }

    @Override
    public Flux<CityModel> findAllCitiesByCountryId(String id) {
        return this.cityRepository.findAllByCountryId(id).map(this.cityEntityMapper::toEntity);
    }

    @Override
    public Flux<CityModel> findAll() {
        log.info("Entro peticion al repository.");
        return this.cityRepository.findAll().map(this.cityEntityMapper::toEntity);
    }
}
