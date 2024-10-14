package com.urbanestia.property.application.beanmodule;

import com.urbanestia.property.application.service.CityManagementService;
import com.urbanestia.property.application.service.CountryManagementService;
import com.urbanestia.property.domain.port.city.CreateCityPort;
import com.urbanestia.property.domain.port.city.FindCityPort;
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
        CreateCityPort createCityPort,
        FindCityPort findCityPort
    ) {
        return new CityManagementService(createCityPort, findCityPort);
    }

}
