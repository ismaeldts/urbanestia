package com.urbanestia.property.infrastructure.adapter.entity.mapper;

import com.urbanestia.property.domain.model.CityModel;
import com.urbanestia.property.infrastructure.adapter.entity.CityEntity;
import com.urbanestia.property.shared.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityDtoMapper extends EntityToDto<CityModel, CityEntity> {
}
