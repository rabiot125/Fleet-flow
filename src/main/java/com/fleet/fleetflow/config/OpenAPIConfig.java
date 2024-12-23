package com.fleet.fleetflow.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI openAPI() {
        Contact contact = new Contact();
        contact.setName("Fleet Flow");

        Info info = new Info()
                .title("Fleet Management Application")
                .version("1.0.0")
                .contact(contact)
                .description("This APIS exposes endpoints to manage vehicles.");

        return new OpenAPI().info(info);
    }
}
