package com.example.gradleproject;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("openapi.yaml");
        String yaml = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\A").next();
        SwaggerParseResult result = new OpenAPIV3Parser().readContents(yaml);
        return result.getOpenAPI();
    }
}
