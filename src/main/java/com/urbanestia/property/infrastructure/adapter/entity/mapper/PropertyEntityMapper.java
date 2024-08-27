package com.urbanestia.property.infrastructure.adapter.entity.mapper;

import com.urbanestia.property.domain.model.PropertyModel;
import com.urbanestia.property.infrastructure.adapter.entity.PropertyEntity;
import com.urbanestia.property.shared.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PropertyEntityMapper extends EntityToDto<PropertyModel, PropertyEntity> {
}
