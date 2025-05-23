package com.urbanestia.property.application.beanmodule;

import com.urbanestia.property.application.service.CityManagementService;
import com.urbanestia.property.application.service.CountryManagementService;
import com.urbanestia.property.domain.port.city.CreateCityPort;
import com.urbanestia.property.domain.port.city.FindCityPort;
import com.urbanestia.property.domain.port.country.CreateCountryPort;
import com.urbanestia.property.domain.port.country.FindCountryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryBeanModuleApplication {

    @Bean
    public CountryManagementService countryManagementService(
        CreateCountryPort createCountryPort,
        FindCountryPort findCountryPort) {
        return new CountryManagementService(createCountryPort, findCountryPort);
    }
}
