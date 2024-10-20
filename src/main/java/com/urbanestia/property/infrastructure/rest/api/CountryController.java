package com.urbanestia.property.infrastructure.rest.api;

import com.urbanestia.property.application.service.CityManagementService;
import com.urbanestia.property.application.service.CountryManagementService;
import com.urbanestia.property.domain.model.CountryModel;
import com.urbanestia.property.infrastructure.adapter.dao.CountryBdDao;
import com.urbanestia.property.infrastructure.adapter.entity.mapper.CountryEntityMapper;
import com.urbanestia.property.infrastructure.rest.api.dto.request.CountryRequest;
import com.urbanestia.property.infrastructure.rest.api.dto.response.CountryResponse;
import com.urbanestia.property.infrastructure.rest.mapper.request.CountryRequestMapper;
import com.urbanestia.property.infrastructure.rest.mapper.response.CityResponseMapper;
import com.urbanestia.property.infrastructure.rest.mapper.response.CountryResponseMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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
  private final CountryBdDao countryBdDao;
  private final CountryEntityMapper countryEntityMapper;

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

  @PostMapping(path = "/create")
  public Mono<CountryModel> saveCountry(@RequestBody CountryRequest countries) {
    log.info("Entro al endpoint de paises.");

    CountryModel countryModel = countryRequestMapper.toEntity(countries);

    return countryManagementService.createCountry(countryModel);
  }


  @PostMapping(path = "/createAll")
  public Flux<CountryModel> createAll(@RequestBody List<CountryRequest> country) {
    return countryManagementService.saveAllCountries(countryRequestMapper.toEntity(country));
  }

}

