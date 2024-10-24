package com.urbanestia.property.infrastructure.adapter.dao;

import com.urbanestia.property.domain.model.PropertyModel;
import com.urbanestia.property.domain.port.property.CreatePropertyPort;
import com.urbanestia.property.domain.port.property.DeletePropertyByIdPort;
import com.urbanestia.property.domain.port.property.FindPropertyPort;
import com.urbanestia.property.domain.port.property.UpdatePropertyByIdPort;
import com.urbanestia.property.infrastructure.adapter.entity.PropertyEntity;
import com.urbanestia.property.infrastructure.adapter.entity.mapper.PropertyEntityMapper;
import com.urbanestia.property.infrastructure.adapter.filter.criteria.PropertyCriteria;
import com.urbanestia.property.infrastructure.adapter.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PropertyBdDao implements CreatePropertyPort, FindPropertyPort, UpdatePropertyByIdPort,
    DeletePropertyByIdPort {

    private final PropertyRepository propertyRepository;
    private final PropertyEntityMapper propertyEntityMapper;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<PropertyModel> createProperty(PropertyModel propertyModel) {
        return propertyRepository
                .save(propertyEntityMapper.toDto(propertyModel))
                .map(this.propertyEntityMapper::toEntity);
    }


    @Override
    public Flux<PropertyModel> findAllPropertiesByCriteria(PropertyCriteria criteria) {

        Query query = new Query();

        if (criteria.getMaxNumberOfBathrooms() != null) {
            query.addCriteria(Criteria.where("numberOfBathrooms").gte(criteria.getMaxNumberOfBathrooms()));
        }
        if (criteria.getMinNumberOfBathrooms() != null) {
            query.addCriteria(Criteria.where("numberOfBathrooms").lte(criteria.getMinNumberOfBathrooms()));
        }
        if (criteria.getMinNumberOfRooms() != null) {
            query.addCriteria(Criteria.where("numberOfRooms").gte(criteria.getMinNumberOfRooms()));
        }
        if (criteria.getMaxNumberOfRooms() != null) {
            query.addCriteria(Criteria.where("numberOfRooms").lte(criteria.getMaxNumberOfRooms()));
        }
        if (criteria.getMaxGuestCapacity() != null) {
            query.addCriteria(Criteria.where("guestCapacity").gte(criteria.getMaxGuestCapacity()));
        }

        if (criteria.getMinGuestCapacity() != null) {
            query.addCriteria(Criteria.where("guestCapacity").gte(criteria.getMinGuestCapacity()));
        }

        return reactiveMongoTemplate.find(query, PropertyEntity.class).map(this.propertyEntityMapper::toEntity);
    }


    @Override
    public Flux<PropertyModel> findAllProperties() {
        return this.propertyRepository.findAll()
                .map(this.propertyEntityMapper::toEntity);
    }

    @Override
    public Mono<Void> updatePropertyById(String id, PropertyModel propertyModel) {
        return this.propertyRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("There's not Property with this id.")))
            .flatMap(existingProperty -> {
              existingProperty.setOwnerId(propertyModel.getOwnerId());
              existingProperty.setTitle(propertyModel.getTitle());
              existingProperty.setDescription(propertyModel.getDescription());
              existingProperty.setGuestCapacity(propertyModel.getGuestCapacity());
              existingProperty.setNumberOfRooms(propertyModel.getNumberOfRooms());
              existingProperty.setNumberOfBathrooms(propertyModel.getNumberOfBathrooms());
              existingProperty.setPrice(propertyModel.getPrice());
              existingProperty.setImgUrl(propertyModel.getImgUrl());
              existingProperty.setDirection(propertyModel.getDirection());
              existingProperty.setDescriptionImages(propertyModel.getDescriptionImages());
              existingProperty.setPublicationDate(propertyModel.getPublicationDate());
              existingProperty.setLatitude(propertyModel.getLatitude());
              existingProperty.setLongitude(propertyModel.getLongitude());
              existingProperty.setSizeInSquareMeters(propertyModel.getSizeInSquareMeters());
              existingProperty.setCondition(propertyModel.getCondition());
              existingProperty.setCityId(propertyModel.getCityId());
              existingProperty.setAddress(propertyModel.getAddress());
              existingProperty.setPropose(propertyModel.getPropose());
              existingProperty.setAcceptsBarter(propertyModel.getAcceptsBarter());
              existingProperty.setYearsOld(propertyModel.getYearsOld());
              existingProperty.setParking(propertyModel.getParking());
              existingProperty.setLatitude(propertyModel.getLatitude());
              existingProperty.setPropertyType(propertyModel.getPropertyType());
              existingProperty.setAmenities(propertyModel.getAmenities());
              existingProperty.setAcceptsVisits(propertyModel.getAcceptsVisits());
              existingProperty.setStratum(propertyModel.getStratum());
              existingProperty.setStatus(propertyModel.getStatus());
              return this.propertyRepository.save(existingProperty);
            })
            .then();
    }

    @Override
    public Flux<PropertyModel> findAllByOwnerId(String ownerId) {
        return this.propertyRepository.findAllByOwnerId(ownerId)
            .map(this.propertyEntityMapper::toEntity);
    }

  @Override
  public Mono<PropertyModel> findPropertyById(String id) {
    return this.propertyRepository.findById(id).map(this.propertyEntityMapper::toEntity) ;
  }

  @Override
  public Mono<Boolean> existsPropertyById(String id) {
    return this.propertyRepository.existsPropertyById(id);
  }

  @Override
  public Mono<Void> deletePropertyById(String id) {
    return this.propertyRepository.deleteById(id);
  }



}
