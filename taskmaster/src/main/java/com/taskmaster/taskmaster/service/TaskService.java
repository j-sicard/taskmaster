package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    public void createdTask(Task task);

    public List<Task> findTasks();

    public Optional<Task> findById(Long id);
}
