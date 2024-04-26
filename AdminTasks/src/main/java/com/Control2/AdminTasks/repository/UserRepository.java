package com.Control2.AdminTasks.repository;
import com.Control2.AdminTasks.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    UserEntity findById(long id);
    List<UserEntity> findAll();
    UserEntity save(UserEntity user);
    void update(UserEntity user);
    void delete(UserEntity user);
}
