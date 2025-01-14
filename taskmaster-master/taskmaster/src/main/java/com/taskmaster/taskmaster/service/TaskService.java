package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.model.Task;

import java.util.List;

public interface TaskService {

    public void createTask(Task task);

    public Boolean deleteTaskById(Long id);

    public List<Task> findAndCleanTasksByUserId(Long userId);
}
