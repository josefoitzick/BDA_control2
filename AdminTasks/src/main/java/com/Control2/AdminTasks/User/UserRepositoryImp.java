package com.Control2.AdminTasks.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImp implements UserRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Optional<User> findByUsername(String username) {
        try (Connection con = sql2o.open()) {
            StringBuilder query = new StringBuilder("SELECT * FROM userTask WHERE username = ");
            query.append("LOWER(:username)"); // Escape username using LOWER function
            User user = con.createQuery(query.toString())
                    .addParameter("username", username.toLowerCase()) // Convert input to lowercase
                    .executeAndFetchFirst(User.class);
            return Optional.ofNullable(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }


    @Override
    public User save(User user) {
        try (Connection con = sql2o.open()) {
            StringBuilder query = new StringBuilder("INSERT INTO userTask");
            query.append("(country, firstname, lastname, password, role, username) ");
            query.append("VALUES (:country, :firstname, :lastname, :password, :role, :username)");

            Long id = (Long) con.createQuery(query.toString())
                    .addParameter("country", user.getCountry())
                    .addParameter("firstname", user.getFirstname())
                    .addParameter("lastname", user.getLastname())
                    .addParameter("password", user.getPassword())
                    .addParameter("role", user.getRole())
                    .addParameter("username", user.getUsername().toLowerCase()) // Escape username
                    .executeUpdate().getKey();

            user.setId(id);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM userTask";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql).executeAndFetch(User.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User findById(Long id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM userTask WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User update(User user) {
        try (Connection con = sql2o.open()) {
            StringBuilder query = new StringBuilder("UPDATE userTask SET ");
            query.append("country = :country, firstname = :firstname, lastname = :lastname, ");
            query.append("password = :password, role = :role, username = :username ");
            query.append("WHERE id = :id");

            con.createQuery(query.toString())
                    .bind(user)
                    .executeUpdate();
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection con = sql2o.open()) {
            con.createQuery("DELETE FROM userTask WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
