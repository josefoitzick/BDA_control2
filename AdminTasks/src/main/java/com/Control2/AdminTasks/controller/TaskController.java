package com.Control2.AdminTasks.controller;

import com.Control2.AdminTasks.service.TaskService;
import org.springframework.web.bind.annotation.*;
import com.Control2.AdminTasks.entity.TaskEntity;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskEntity> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable long id) {
        return taskService.findById(id);
    }

    @PostMapping(value = "create")
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        return taskService.save(task);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable long id, @RequestBody TaskEntity task) {
        task.setId(id);
        taskService.update(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        TaskEntity task = taskService.findById(id);
        taskService.delete(task);
    }
}
