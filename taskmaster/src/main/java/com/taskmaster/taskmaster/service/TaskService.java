package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.model.Task;

import java.util.List;

public interface TaskService {

    public void createdTask(Task task);

    public List<Task> findTasks();
}
