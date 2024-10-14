package com.urbanestia.property.infrastructure.rest.api;

import com.urbanestia.property.application.service.CityManagementService;
import com.urbanestia.property.infrastructure.rest.api.dto.request.CityRequest;
import com.urbanestia.property.infrastructure.rest.api.dto.response.CityResponse;
import com.urbanestia.property.infrastructure.rest.mapper.response.CityRequestMapper;
import com.urbanestia.property.infrastructure.rest.mapper.response.CityResponseMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/cities")
@RestController
public class CityController {

  private final CityManagementService cityManagementService;
  private final CityRequestMapper cityRequestMapper;
  private final CityResponseMapper cityResponseMapper;

  @PostMapping
  public Flux<CityResponse> createCities(@RequestBody List<CityRequest> citiesRequest) {
    return cityManagementService.saveAllCities(cityRequestMapper.toEntity(citiesRequest))
        .map(this.cityResponseMapper::toDto);
  }

  @GetMapping(path = "/findAllByCountryId")
  public Flux<CityResponse> findAllByCountryId(@PathVariable("countryId") String country) {
    return cityManagementService.findAllByCountryId(country).map(this.cityResponseMapper::toDto);
  }
}
