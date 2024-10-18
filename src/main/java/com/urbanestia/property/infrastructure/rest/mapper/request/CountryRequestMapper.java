package com.urbanestia.property.infrastructure.rest.mapper.request;

import com.urbanestia.property.domain.model.CountryModel;
import com.urbanestia.property.infrastructure.rest.api.dto.request.CountryRequest;
import com.urbanestia.property.shared.EntityToDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CountryRequestMapper extends EntityToDto<CountryModel, CountryRequest> {

}
