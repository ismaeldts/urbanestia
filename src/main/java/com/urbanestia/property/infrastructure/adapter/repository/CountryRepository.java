package com.urbanestia.property.infrastructure.adapter.repository;

import com.urbanestia.property.infrastructure.adapter.entity.CountryEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryRepository extends ReactiveCrudRepository<CountryEntity, UUID> {
}
