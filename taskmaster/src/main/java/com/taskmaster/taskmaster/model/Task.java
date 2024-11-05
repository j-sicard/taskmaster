package com.taskmaster.taskmaster.model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Task {

    @Id
    private Long id;

    private String description;

    private Boolean completed;

    private LocalDateTime deadline;

    @OneToMany(mappedBy="category")
    private Set<Category> category;

    public Task() {
    }

    public Task(Long id, String description, Boolean completed, LocalDateTime deadline, Set<Category> category) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.deadline = deadline;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                ", deadline=" + deadline +
                ", category=" + category +
                '}';
    }
}
