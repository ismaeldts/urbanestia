package com.urbanestia.property.infrastructure.adapter.dao.city;

import com.urbanestia.property.domain.model.CityModel;
import com.urbanestia.property.domain.port.city.CreateCityPort;
import com.urbanestia.property.infrastructure.adapter.entity.mapper.CityDtoMapper;
import com.urbanestia.property.infrastructure.adapter.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CityBdDao implements CreateCityPort {

    private final CityRepository cityRepository;
    private final CityDtoMapper cityDtoMapper;

    @Override
    public Mono<CityModel> createCity(CityModel cityModel) {
        return cityRepository.save(cityDtoMapper.toDto(cityModel))
                .map(this.cityDtoMapper::toEntity);
    }

    public Mono<Void> deleteProperty(String status){
        return Mono.just(this.cityRepository.updatePropertyStatus(status));
    }
}
