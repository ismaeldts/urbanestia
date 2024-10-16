package com.urbanestia.property;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition
 public class McsvPropertyApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvPropertyApplication.class, args);
	}

}
