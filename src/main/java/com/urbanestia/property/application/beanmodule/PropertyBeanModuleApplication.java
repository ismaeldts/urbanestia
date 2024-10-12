package com.urbanestia.property.application.beanmodule;

import com.urbanestia.property.application.service.PropertyManagementService;
import com.urbanestia.property.domain.port.property.CreatePropertyPort;
import com.urbanestia.property.domain.port.property.DeletePropertyByIdPort;
import com.urbanestia.property.domain.port.property.FindPropertyPort;
import com.urbanestia.property.domain.port.property.UpdatePropertyByIdPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertyBeanModuleApplication {

    @Bean
    public PropertyManagementService propertyManagementService(
        CreatePropertyPort createPropertyPort,
        FindPropertyPort findPropertyPort,
        UpdatePropertyByIdPort updatePropertyByIdPort,
        DeletePropertyByIdPort deletePropertyByIdPort) {
        return new PropertyManagementService(
            createPropertyPort, findPropertyPort,
            updatePropertyByIdPort, deletePropertyByIdPort);
    }
}
