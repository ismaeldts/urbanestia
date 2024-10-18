package com.urbanestia.property.infrastructure.rest.api;

import com.urbanestia.property.application.service.CityManagementService;
import com.urbanestia.property.infrastructure.rest.api.dto.request.CityRequest;
import com.urbanestia.property.infrastructure.rest.api.dto.response.CityResponse;
import com.urbanestia.property.infrastructure.rest.mapper.response.CityRequestMapper;
import com.urbanestia.property.infrastructure.rest.mapper.response.CityResponseMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/cities")
@RestController
@Slf4j
public class CityController {

  private final CityManagementService cityManagementService;
  private final CityRequestMapper cityRequestMapper;
  private final CityResponseMapper cityResponseMapper;

  @PostMapping
  public Flux<CityResponse> createCities(@RequestBody List<CityRequest> citiesRequest) {
    log.info("Entro peticion para crear ciudades.");
    return cityManagementService.saveAllCities(cityRequestMapper.toEntity(citiesRequest))
        .map(this.cityResponseMapper::toDto);
  }

  @GetMapping(path = "/findAllByCountryId/{countryId}")
  public Flux<CityResponse> findAllByCountryId(@PathVariable("countryId") String country) {
    log.info("Entro peticion para buscar todas las ciudades por id del pais.");
    return cityManagementService.findAllByCountryId(country).map(this.cityResponseMapper::toDto);
  }

  @GetMapping(path = "/findById/{countryId}")
  public Mono<CityResponse> findById(@PathVariable("countryId") String country) {
    log.info("Entro peticion para buscar ciudades por le id del pais.");
    return cityManagementService.findById(country).map(this.cityResponseMapper::toDto);
  }

  @GetMapping(path = "/findAll")
  public Flux<CityResponse> findAll() {
    log.info("Entro peticion para buscar todas las ciudades.");
    return cityManagementService.findAll().map(this.cityResponseMapper::toDto);
  }
}
