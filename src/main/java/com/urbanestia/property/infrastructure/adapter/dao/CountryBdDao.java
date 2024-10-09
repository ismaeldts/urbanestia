package com.urbanestia.property.infrastructure.adapter.dao;

import com.urbanestia.property.domain.model.CountryModel;
import com.urbanestia.property.domain.port.country.CreateCountryPort;
import com.urbanestia.property.infrastructure.adapter.entity.mapper.CountryEntityMapper;
import com.urbanestia.property.infrastructure.adapter.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CountryBdDao implements CreateCountryPort {

    private final CountryRepository countryRepository;
    private final CountryEntityMapper countryEntityMapper;

    @Override
    public Mono<CountryModel> createCountry(CountryModel countryModel) {
        return this.countryRepository
                .save(countryEntityMapper.toDto(countryModel))
                .map(this.countryEntityMapper::toEntity)
                .switchIfEmpty(Mono.error(new RuntimeException("")));
    }
}
