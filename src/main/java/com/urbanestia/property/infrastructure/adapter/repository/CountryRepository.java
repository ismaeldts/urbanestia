package com.urbanestia.property.infrastructure.adapter.repository;

import com.urbanestia.property.infrastructure.adapter.entity.CountryEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends ReactiveMongoRepository<CountryEntity, String> {
}
