package com.urbanestia.property.infrastructure.adapter.entity.mapper;

import com.urbanestia.property.domain.model.CountryModel;
import com.urbanestia.property.infrastructure.adapter.entity.CountryEntity;
import com.urbanestia.property.shared.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryEntityMapper extends EntityToDto<CountryModel, CountryEntity> {
}
