package com.Control2.AdminTasks.repository;



import com.Control2.AdminTasks.entity.UserEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserRepositoryImp implements UserRepository{
    private Map<Long, UserEntity> users = new HashMap<>();
    private long nextId = 1;

    @Override
    public UserEntity findById(long id){
        return users.get(id);
    }
    @Override
    public List<UserEntity> findAll(){
        return new ArrayList<>(users.values());
    }
    @Override
    public UserEntity save(UserEntity user){
        user.setId(nextId++);
        users.put(user.getId(),user);
        return user;
    }

    @Override
    public void update(UserEntity user){
        if(users.containsKey(user.getId())){
            users.put(user.getId(), user);
        }
    }
    @Override
    public void delete(UserEntity user){
        users.remove(user.getId());
    }
}
