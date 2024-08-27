package com.urbanestia.property.infrastructure.rest.mapper.request;

import com.urbanestia.property.domain.model.PropertyModel;
import com.urbanestia.property.infrastructure.rest.api.dto.request.PropertyRequest;
import com.urbanestia.property.shared.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PropertyRequestMapper extends EntityToDto<PropertyModel, PropertyRequest> {
}
