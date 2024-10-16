package com.urbanestia.property.infrastructure.rest.api;

import com.urbanestia.property.application.service.CountryManagementService;
import com.urbanestia.property.infrastructure.rest.api.dto.request.CountryRequest;
import com.urbanestia.property.infrastructure.rest.api.dto.response.BaseEntityResponse;
import com.urbanestia.property.infrastructure.rest.api.dto.response.CountryResponse;
import com.urbanestia.property.infrastructure.rest.mapper.request.CountryRequestMapper;
import com.urbanestia.property.infrastructure.rest.mapper.response.CountryResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequestMapping(path = "/api/v1/country")
@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryManagementService countryManagementService;
    private final CountryResponseMapper countryResponseMapper;
    private final CountryRequestMapper countryRequestMapper;

    @PostMapping
    public Mono<ResponseEntity<BaseEntityResponse>> saveAllCountries(@RequestBody CountryRequest countryRequest) {
        return Mono.just(countryRequestMapper.toEntity(countryRequest))
                .flatMap(this.countryManagementService::createCountry)
                .then(Mono.just(ResponseEntity.status(201)
                        .body(new BaseEntityResponse("201", "El país ha sido creado con exito",
                                LocalDateTime.now()))));
    }

    @GetMapping
    public Flux<CountryResponse> findAll() {
        return countryManagementService.findAll().map(this.countryResponseMapper::toDto);
    }

}

