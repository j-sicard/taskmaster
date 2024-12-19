package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    List<Task> getTasks(){
        return taskService.findTasks();
    }

    @PostMapping("/new")
    void newTask(@RequestBody Task newTask){
       taskService.createTask(newTask);
    }

    @GetMapping("/task/{id}")
    Task one(@PathVariable Long id) {
        return taskService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Task not found with ID: " + id
                ));
    }



}
