package com.Control2.AdminTasks.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {
    @Bean
    public Sql2o sql2o() {
        return new Sql2o("jdbc:postgresql://localhost:5433/tareas", "postgres", "1234");
    }
}
