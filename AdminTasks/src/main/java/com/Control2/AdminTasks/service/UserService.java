package com.Control2.AdminTasks.service;

import org.springframework.stereotype.Service;
import com.Control2.AdminTasks.entity.UserEntity;
import com.Control2.AdminTasks.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserEntity findById(long id) {
        return userRepository.findById(id);
    }
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }
    public void update(UserEntity user) {
        userRepository.update(user);
    }
    public void delete(UserEntity user) {
        userRepository.delete(user);
    }
}
