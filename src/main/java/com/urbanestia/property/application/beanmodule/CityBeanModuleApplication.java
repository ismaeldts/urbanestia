package com.urbanestia.property.application.beanmodule;

import com.urbanestia.property.application.service.CityManagementService;
import com.urbanestia.property.domain.port.city.CreateCityPort;
import com.urbanestia.property.domain.port.city.FindCityPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityBeanModuleApplication {

    @Bean
    public CityManagementService cityManagementService(
            CreateCityPort createCityPort,
            FindCityPort findCityPort) {
        return new CityManagementService(createCityPort, findCityPort);
    }
}
