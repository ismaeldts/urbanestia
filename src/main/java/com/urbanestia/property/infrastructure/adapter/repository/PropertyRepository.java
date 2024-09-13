package com.urbanestia.property.infrastructure.adapter.repository;

import com.urbanestia.property.infrastructure.adapter.entity.PropertyEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends ReactiveMongoRepository<PropertyEntity, String> {


}
