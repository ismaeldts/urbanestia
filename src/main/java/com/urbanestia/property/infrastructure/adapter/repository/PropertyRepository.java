package com.urbanestia.property.infrastructure.adapter.repository;

import com.urbanestia.property.infrastructure.adapter.entity.PropertyEntity;
 import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface PropertyRepository extends ReactiveCrudRepository<PropertyEntity, UUID>{

    Flux<PropertyEntity> findAllByOwner(String name);

}
