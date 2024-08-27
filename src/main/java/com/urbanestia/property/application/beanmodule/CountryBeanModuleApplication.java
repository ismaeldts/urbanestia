package com.urbanestia.property.application.beanmodule;

import com.urbanestia.property.application.service.city.CityManagementService;
import com.urbanestia.property.application.service.country.CountryManagementService;
import com.urbanestia.property.domain.port.city.CreateCityPort;
import com.urbanestia.property.domain.port.country.CreateCountryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryBeanModuleApplication {

    @Bean
    public CountryManagementService countryManagementService(
            CreateCountryPort createCountryPort) {
        return new CountryManagementService(createCountryPort);
    }

    @Bean
    public CityManagementService cityManagementService(
            CreateCityPort createCityPort
    ) {
        return new CityManagementService(createCityPort);
    }

}
