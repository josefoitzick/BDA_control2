package com.Control2.AdminTasks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/auth/**") // El patrón de URL al que deseas aplicar CORS
                .allowedOrigins("http://localhost:3000") // El origen del cliente
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("*") // Cabeceras permitidas
                .allowCredentials(true); // Permitir credenciales
    }
}
