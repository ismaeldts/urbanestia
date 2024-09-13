package com.urbanestia.property.infrastructure.adapter.repository;

import com.urbanestia.property.infrastructure.adapter.entity.CityEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends ReactiveMongoRepository<CityEntity, String> {

}
