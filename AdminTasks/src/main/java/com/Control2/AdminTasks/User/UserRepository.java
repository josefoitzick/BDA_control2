package com.Control2.AdminTasks.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    //query methods
    Optional<User> findByUsername(String username);
    User findById(long id);



}
