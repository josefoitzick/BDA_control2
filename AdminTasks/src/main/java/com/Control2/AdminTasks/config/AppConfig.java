package com.Control2.AdminTasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.Control2.AdminTasks.repository.TaskRepository;
import com.Control2.AdminTasks.repository.TaskRepositoryImp;

@Configuration
public class AppConfig {

    @Bean
    public TaskRepository taskRepository() {
        return new TaskRepositoryImp(); // o crea una instancia de tu implementación del repositorio aquí
    }
    /*
    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImp(); // o crea una instancia de tu implementación del repositorio aquí
    }

     */
}
