package com.Control2.AdminTasks.repository;

import org.springframework.stereotype.Repository;
import com.Control2.AdminTasks.entity.TaskEntity;

import java.util.List;

@Repository
public interface TaskRepository {
    TaskEntity findById(long id);

    List<TaskEntity> findAll();

    TaskEntity save(TaskEntity task);

    void update(TaskEntity task);

    void delete(TaskEntity task);
}