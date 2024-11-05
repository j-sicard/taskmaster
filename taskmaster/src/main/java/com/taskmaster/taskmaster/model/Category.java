package com.taskmaster.taskmaster.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {

    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Task task;

    public Category() {
    }

    public Category(Long id, String name, Task task) {
        this.id = id;
        this.name = name;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", task=" + task +
                '}';
    }
}
