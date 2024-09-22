package com.SpringBootwebservice.Springboot_restfull_webService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Document",
				description = "Spring Boot REST API Document",
				version = "v1",
				contact = @Contact(
						name = "Sandy",
						email = "sandy@gmail.com"
				),
				license = @License(
						name = "Apache 2.0"
				)
		)
)
public class SpringbootRestfullWebServiceApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfullWebServiceApplication.class, args);
	}

}
