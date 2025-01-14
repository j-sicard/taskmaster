package com.taskmaster.taskmaster.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserData user;

    public Task(Long id, String description, LocalDateTime deadline, UserData user) {
        this.taskId = id;
        this.description = description;
        this.deadline = deadline;
        this.user = user;
    }

    public Task() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + taskId +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", user=" + user +
                '}';
    }
}
