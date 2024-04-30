package com.Control2.AdminTasks.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public List<Task> getTasksByCompletion(boolean completed) { return taskRepository.findByCompleted(completed); }

    public Task updateTask(Task task) {
        // Verificar si la tarea existe antes de actualizarla
        Task existingTask = taskRepository.findById(task.getId());
        if (existingTask != null) {
            return taskRepository.update(task);
        } else {
            // Manejar la situación si la tarea no existe
            System.out.println("La tarea con ID " + task.getId() + " no existe.");
            return null;
        }
    }

    public boolean deleteTaskById(Long id) {
        Task existingTask = taskRepository.findById(id);
        if (existingTask != null) {
            taskRepository.deleteById(id);
            return true;
        } else {
            System.out.println("La tarea con ID " + id + " no existe.");
            return false;
        }
    }
}
