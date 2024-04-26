package com.Control2.AdminTasks.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long id_user;
    String title;
    String description;
    Date date;


    public TaskEntity(long id, long id_user, String title, String description, Date date) {
        this.id = id;
        this.id_user = id_user;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public TaskEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
