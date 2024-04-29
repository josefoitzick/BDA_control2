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
            User user = con.createQuery("SELECT * FROM userTask WHERE username = :username")
                    .addParameter("username", username)
                    .executeAndFetchFirst(User.class);
            return Optional.ofNullable(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public User save(User user){
        try(Connection con = sql2o.open()){
            Long id = (Long) con.createQuery("INSERT INTO userTask(country, firstname, lastname, password, role, username)" +
                            "VALUES(:country, :firstname, :lastname, :password, :role, :username)")
                    .addParameter("country", user.getCountry())
                    .addParameter("firstname", user.getFirstname())
                    .addParameter("lastname", user.getLastname())
                    .addParameter("password", user.getPassword())
                    .addParameter("role", user.getRole())
                    .addParameter("username", user.getUsername())
                    .executeUpdate().getKey();

            // Asignamos el ID generado automáticamente al usuario
            user.setId(id);

            return user;
        } catch(Exception e){
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
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM userTask WHERE id = *id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(User.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public User update(User user) {
        try (Connection con = sql2o.open()) {
            con.createQuery("UPDATE userTask SET country = :country, firstname = :firstname, lastname = :lastname, " +
                            "password = :password, role = :role, username = :username WHERE id = :id")
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
