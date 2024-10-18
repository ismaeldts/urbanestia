package com.urbanestia.property.infrastructure.adapter.dao;

import com.urbanestia.property.domain.model.CountryModel;
import com.urbanestia.property.domain.port.country.CreateCountryPort;
import com.urbanestia.property.domain.port.country.FindCountryPort;
import com.urbanestia.property.infrastructure.adapter.entity.CountryEntity;
import com.urbanestia.property.infrastructure.adapter.entity.mapper.CountryEntityMapper;
import com.urbanestia.property.infrastructure.adapter.repository.CountryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CountryBdDao implements CreateCountryPort, FindCountryPort {

    private final CountryRepository countryRepository;
    private final CountryEntityMapper countryEntityMapper;

    @Override
    public Mono<CountryModel> createCountry(CountryModel countryModel) {
        return this.countryRepository
                .save(countryEntityMapper.toDto(countryModel))
                .map(this.countryEntityMapper::toEntity)
            .switchIfEmpty(Mono.error(new RuntimeException("")));
    }

    public Mono<CountryEntity> createCountry2(CountryModel countryModel){
        return countryRepository.save(this.countryEntityMapper.toDto(countryModel));
    }

    @Override
    public Flux<CountryModel> createAll(List<CountryModel> countryModel) {
        return Flux.fromIterable(countryModel)
            .flatMap(countryModels ->
                this.countryRepository
                    .save(countryEntityMapper.toDto(countryModels))
                    .map(this.countryEntityMapper::toEntity)
            );
    }

    @Override
    public Mono<CountryModel> findCountryById(String id) {
        return countryRepository.findById(id).map(this.countryEntityMapper::toEntity);
    }

    @Override
    public Flux<CountryModel> findAll() {
        return countryRepository.findAll().map(this.countryEntityMapper::toEntity);
    }
}
