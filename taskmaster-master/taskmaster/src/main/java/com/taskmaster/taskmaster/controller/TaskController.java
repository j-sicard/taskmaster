package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.business.TaskBusiness;
import com.taskmaster.taskmaster.dto.TaskDTO;
import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.model.UserData;
import com.taskmaster.taskmaster.service.TaskService;
import com.taskmaster.taskmaster.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskBusiness taskBusiness;


    @GetMapping("/tasks/{userId}")
    public ResponseEntity<List<TaskDTO>> getTasksByUserId(@PathVariable Long userId) {
        List<TaskDTO> tasks = taskService.findAllTaskByUserId(userId);
            return ResponseEntity.ok(tasks);
    }


    //TODO ResponseEntity not created
    @PostMapping("/new")
    void newTask(@RequestBody TaskDTO newTask){
       taskBusiness.createdTask(newTask);
    }


    @DeleteMapping("/delete/{taskId}")
    ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        if (taskService.deleteTaskById(taskId)) {
            return ResponseEntity.ok("Task " + taskId + " deleted.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task " + taskId + " not found.");
    }
}
