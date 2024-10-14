package com.urbanestia.property.infrastructure.adapter.repository;

import com.urbanestia.property.infrastructure.adapter.entity.PropertyEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PropertyRepository extends ReactiveMongoRepository<PropertyEntity, String> {

  Flux<PropertyEntity> findAllByOwnerId(String ownerId);

  Mono<Boolean> existsPropertyById(String propertyId);

}
