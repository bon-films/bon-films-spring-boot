package com.comp586.bonfilms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**").allowedOrigins("https://www.nguyentony.com")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("Access-Control-Allow-Origin", "*")
                        .exposedHeaders("Access-Control-Allow-Headers",
                                "Content-Type, Authorization, Content-Length, X-Requested-With")
                        .allowCredentials(true).maxAge(3600);
            }
        };
    }
}