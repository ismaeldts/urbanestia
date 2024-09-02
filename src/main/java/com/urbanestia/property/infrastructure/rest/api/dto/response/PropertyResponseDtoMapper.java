package com.urbanestia.property.infrastructure.rest.api.dto.response;

import com.urbanestia.property.domain.model.PropertyModel;
import com.urbanestia.property.infrastructure.adapter.entity.dto.PropertyDTO;
import com.urbanestia.property.shared.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PropertyResponseDtoMapper extends EntityToDto<PropertyModel, PropertyResponse> {
}
