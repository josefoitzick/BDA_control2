package com.Control2.AdminTasks.repository;


import com.Control2.AdminTasks.entity.TaskEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TaskRepositoryImp implements TaskRepository {
    private Map<Long, TaskEntity> tasks = new HashMap<>();
    private long nextId = 1;

    @Override
    public TaskEntity findById(long id) {
        return tasks.get(id);
    }

    @Override
    public List<TaskEntity> findAll() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public TaskEntity save(TaskEntity task) {
        task.setId(nextId++);
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public void update(TaskEntity task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        }
    }

    @Override
    public void delete(TaskEntity task) {
        tasks.remove(task.getId());
    }
}