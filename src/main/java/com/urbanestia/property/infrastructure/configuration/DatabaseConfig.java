package com.urbanestia.property.infrastructure.configuration;

 import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableConfigurationProperties({R2dbcProperties.class, FlywayProperties.class})
//public class DatabaseConfig {
//
//
//    @Bean(initMethod = "migrate")
//    public Flyway flyway(FlywayProperties flywayProperties) {
//        System.out.println("Flyway URL: " + flywayProperties.getUrl());
//        System.out.println("Flyway User: " + flywayProperties.getUser());
//        return Flyway
//                .configure()
//                .baselineOnMigrate(true)
//                .dataSource(
//                        flywayProperties.getUrl(),
//                        flywayProperties.getUser(),
//                        flywayProperties.getPassword()
//                )
//                .locations(flywayProperties.getLocations().toArray(String[]::new))
//                .load();
//    }
//}
//