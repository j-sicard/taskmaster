package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/api/tasks")
    public List<Task> getTasks(){
        return taskService.FindTasks();
    }

}
