package com.Control2.AdminTasks.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    //query methods
    Optional<User> findByUsername(String username);
    User save(User user);
    List<User> findAll();
    User findById(Long id);
    User update(User user);
    boolean deleteById(Long id);

}
