package com.Control2.AdminTasks.service;

import com.Control2.AdminTasks.entity.TaskEntity;
import com.Control2.AdminTasks.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskEntity findById(long id) {
        return taskRepository.findById(id);
    }

    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    public TaskEntity save(TaskEntity task) {
        // Aquí podrías agregar lógica adicional antes de guardar la tarea, si es necesario
        return taskRepository.save(task);
    }

    public void update(TaskEntity task) {
        // Aquí podrías agregar lógica adicional antes de actualizar la tarea, si es necesario
        taskRepository.update(task);
    }

    public void delete(TaskEntity task) {
        // Aquí podrías agregar lógica adicional antes de eliminar la tarea, si es necesario
        taskRepository.delete(task);
    }
}
