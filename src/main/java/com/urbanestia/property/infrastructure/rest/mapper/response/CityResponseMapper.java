package com.urbanestia.property.infrastructure.rest.mapper.response;

import com.urbanestia.property.domain.model.CityModel;
import com.urbanestia.property.infrastructure.rest.api.dto.response.CityResponse;
import com.urbanestia.property.shared.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CityResponseMapper extends EntityToDto<CityModel, CityResponse> {

}
