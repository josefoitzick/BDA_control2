package com.Control2.AdminTasks.controller;

import org.springframework.web.bind.annotation.*;
import com.Control2.AdminTasks.entity.UserEntity;
import com.Control2.AdminTasks.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable long id, @RequestBody UserEntity user) {
        user.setId(id);
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        UserEntity user = userService.findById(id);
        userService.delete(user);
    }
}
