package com.urbanestia.property.infrastructure.rest.api;

import com.urbanestia.property.application.service.CityManagementService;
import com.urbanestia.property.application.service.CountryManagementService;
import com.urbanestia.property.infrastructure.rest.api.dto.request.CountryRequest;
import com.urbanestia.property.infrastructure.rest.api.dto.response.BaseEntityResponse;
import com.urbanestia.property.infrastructure.rest.api.dto.response.CountryResponse;
import com.urbanestia.property.infrastructure.rest.mapper.request.CountryRequestMapper;
import com.urbanestia.property.infrastructure.rest.mapper.response.CityResponseMapper;
import com.urbanestia.property.infrastructure.rest.mapper.response.CountryResponseMapper;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/v1/countries")
@AllArgsConstructor
@Slf4j
public class CountryController {

  private final CountryManagementService countryManagementService;
  private final CountryRequestMapper countryRequestMapper;
  private final CountryResponseMapper countryResponseMapper;
  private final CityManagementService cityManagementService;
  private final CityResponseMapper cityResponseMapper;

  @PostMapping
  public Mono<BaseEntityResponse> saveAllCountries(@RequestBody List<CountryRequest> countries) {
    log.info("Entro al endpoint de paises.");
    countryManagementService.saveAllCountries(
        countries.stream().map(this.countryRequestMapper::toEntity).collect(
            Collectors.toList())).map(this.countryResponseMapper::toDto);
    return Mono.just(
        new BaseEntityResponse("201", "Los paises fueron creados con exito.", LocalDateTime.now()));
  }

  @GetMapping(path = "/findAllCountries")
  public Flux<CountryResponse> findAllCountries() {
    return countryManagementService.findAll()
        .flatMap(country ->
            cityManagementService.findAllByCountryId(country.getId())
                .map(cityResponseMapper::toDto)
                .collectList()
                .map(cities -> {
                  CountryResponse countryResponse = countryResponseMapper.toDto(country);
                  countryResponse.setCities(cities);
                  return countryResponse;
                })
        );

  }


}
