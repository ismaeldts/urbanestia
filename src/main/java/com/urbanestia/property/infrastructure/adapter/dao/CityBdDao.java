package com.urbanestia.property.infrastructure.adapter.dao;

import com.urbanestia.property.domain.model.CityModel;
import com.urbanestia.property.domain.port.city.CreateCityPort;
import com.urbanestia.property.infrastructure.adapter.entity.mapper.CityEntityMapper;
import com.urbanestia.property.infrastructure.adapter.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CityBdDao implements CreateCityPort {

    private final CityRepository cityRepository;
    private final CityEntityMapper cityEntityMapper;

    @Override
    public Mono<CityModel> createCity(CityModel cityModel) {
        return cityRepository.save(cityEntityMapper.toDto(cityModel))
                .map(this.cityEntityMapper::toEntity);
    }

   // public Mono<Void> deleteProperty(String status){
   //     return Mono.just(this.cityRepository.updatePropertyStatus(status));
   // }
}
