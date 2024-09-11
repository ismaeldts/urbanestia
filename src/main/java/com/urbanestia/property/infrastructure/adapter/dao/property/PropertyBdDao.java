package com.urbanestia.property.infrastructure.adapter.dao.property;

import com.urbanestia.property.domain.model.PropertyModel;
import com.urbanestia.property.domain.port.property.CreatePropertyPort;
import com.urbanestia.property.domain.port.property.FindPropertyPort;
import com.urbanestia.property.infrastructure.adapter.entity.PropertyEntity;
import com.urbanestia.property.infrastructure.adapter.entity.mapper.PropertyEntityMapper;
import com.urbanestia.property.infrastructure.adapter.filter.criteria.PropertyCriteria;
import com.urbanestia.property.infrastructure.adapter.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PropertyBdDao implements CreatePropertyPort, FindPropertyPort {

    private final PropertyRepository propertyRepository;
    private final PropertyEntityMapper propertyEntityMapper;
    private final DatabaseClient databaseClient;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public Flux<PropertyEntity> findProperties(PropertyCriteria filter) {
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM properties WHERE 1=1");

        // Append conditions based on filter criteria
        if (filter.getMinNumberOfRooms() != null) {
            queryBuilder.append(" AND number_of_rooms >= ").append(filter.getMinNumberOfRooms());
        }
        if (filter.getMaxNumberOfRooms() != null) {
            queryBuilder.append(" AND number_of_rooms <= ").append(filter.getMaxNumberOfRooms());
        }
        if (filter.getMinNumberOfBathrooms() != null) {
            queryBuilder.append(" AND number_of_bathrooms >= ").append(filter.getMinNumberOfBathrooms());
        }
        if (filter.getMaxNumberOfBathrooms() != null) {
            queryBuilder.append(" AND number_of_bathrooms <= ").append(filter.getMaxNumberOfBathrooms());
        }

        // Execute the query
        return databaseClient.sql(queryBuilder.toString())
                .map(row -> {
                    PropertyEntity entity = new PropertyEntity();
                    entity.setId(row.get("id", Long.class));
                    entity.setOwner(row.get("owner", String.class));
                    entity.setTitle(row.get("title", String.class));
                    entity.setDescription(row.get("description", String.class));
                    // Note: Handle complex objects like CountryModel separately if needed
                    entity.setNumberOfRooms(row.get("number_of_rooms", Integer.class));
                    entity.setNumberOfBathrooms(row.get("number_of_bathrooms", Integer.class));
                    entity.setType(row.get("type", String.class));
                    entity.setPublicationDate(row.get("publication_date", LocalDateTime.class));
                    return entity;
                })
                .all();
    }

    @Override
    public Mono<PropertyModel> createProperty(PropertyModel propertyModel) {
        return propertyRepository
                .save(propertyEntityMapper.toDto(propertyModel))
                .map(this.propertyEntityMapper::toEntity);
    }


    @Override
    public Flux<PropertyModel> findAllPropertiesByCriteria(PropertyCriteria criteria) {
        return propertyRepository.findAll()
                .map(this.propertyEntityMapper::toEntity);
    }

    @Override
    public Flux<PropertyModel> findAllProperties() {
        return this.propertyRepository.findAll()
                .map(this.propertyEntityMapper::toEntity);
    }

    @Override
    public Mono<PropertyModel> updatePropertyById(UUID id, PropertyModel propertyModel) {
        return this.propertyRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("")))
                .flatMap(this.propertyRepository::save)
                .map(this.propertyEntityMapper::toEntity);
    }

}
