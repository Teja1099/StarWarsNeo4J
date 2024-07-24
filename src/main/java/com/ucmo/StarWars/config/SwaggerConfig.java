package com.ucmo.StarWars.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Star Wars App using Neo4J")
                .description("Spring Boot Rest API")
                .contact(new Contact().name("Neo4J"))
                .version("1.0.0"));
    }
}
