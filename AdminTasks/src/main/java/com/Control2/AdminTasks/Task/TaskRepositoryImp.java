package com.Control2.AdminTasks.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskRepositoryImp implements TaskRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public Task save(Task task){
        try(Connection con = sql2o.open()){
            Long id = (Long) con.createQuery("INSERT INTO Task (id_usertask, title, description, completed, due_date) " +
                            "VALUES (:id_usertask, :title, :description, :completed, :due_date)")
                    .addParameter("id_usertask", task.getId_usertask())
                    .addParameter("title", task.getTitle())
                    .addParameter("description", task.getDescription())
                    .addParameter("completed", task.isCompleted())
                    .addParameter("due_date", task.getDue_date())
                    .executeUpdate()
                    .getKey();

            // Asignamos el ID generado automáticamente a la tarea
            task.setId(id);

            return task;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<Task> findAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Task")
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println("Error al obtener todas las tareas: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Task> findByUserId(Long userId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Task WHERE id_usertask = :id_usertask")
                    .addParameter("id_usertask", userId)
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println("Error al obtener las tareas por ID de usuario: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Task update(Task task) {
        try (Connection con = sql2o.open()) {
            con.createQuery("UPDATE Task SET id_usertask = :id_userTask, title = :title, " +
                            "description = :description, completed = :completed, due_date = :due_date WHERE id = :id")
                    .addParameter("id", task.getId())
                    .addParameter("id_usertask", task.getId_usertask())
                    .addParameter("title", task.getTitle())
                    .addParameter("description", task.getDescription())
                    .addParameter("completed", task.isCompleted())
                    .addParameter("due_date", task.getDue_date())
                    .executeUpdate();
            return task;
        } catch (Exception e) {
            System.out.println("Error al actualizar la tarea: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Connection con = sql2o.open()) {
            con.createQuery("DELETE FROM Task WHERE id = :id")
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar la tarea por ID: " + e.getMessage());
        }
    }
    @Override
    public Task findById(Long id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Task WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Task.class);
        } catch (Exception e) {
            System.out.println("Error al obtener la tarea por ID: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Task> findByCompleted(boolean completed){
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM Task WHERE completed = :completed")
                    .addParameter("completed", completed)
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println("Error al obtener la tarea por completed: " + e.getMessage());
            return null;
        }
    }

}
