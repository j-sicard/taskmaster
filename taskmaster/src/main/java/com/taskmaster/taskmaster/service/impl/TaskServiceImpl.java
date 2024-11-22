package com.taskmaster.taskmaster.service.impl;

import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.reporitory.TaskRepository;
import com.taskmaster.taskmaster.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void createdTask(Task task){
        taskRepository.save(task);
    }

    public List<Task> findTasks(){
        return taskRepository.findAll();
    }
}
