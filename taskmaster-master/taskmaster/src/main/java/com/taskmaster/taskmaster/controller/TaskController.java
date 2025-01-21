package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.business.TaskBusiness;
import com.taskmaster.taskmaster.dto.TaskDTO;
import com.taskmaster.taskmaster.service.TaskService;
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

    //TODO exception for userid not found not created
    @GetMapping("/tasks/{userId}")
    public ResponseEntity<List<TaskDTO>> getTasksByUserId(@PathVariable Long userId) {
            return ResponseEntity.ok(taskBusiness.getTasksByUserId(userId));
    }

    //TODO ResponseEntity not created
    @PostMapping("/new")
    void newTask(@RequestBody TaskDTO newTask){
       taskBusiness.createdTask(newTask);
    }


    //TODO the if is probably a work logic
    //TODO modify it for don't must test it
    @DeleteMapping("/delete/{taskId}")
    ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        if (taskService.deleteTaskById(taskId)) {
            return ResponseEntity.ok("Task " + taskId + " deleted.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task " + taskId + " not found.");
    }


    //TODO modify for use response entity
    @PutMapping("/modify/{taskId}")
    void modifyTask(@RequestBody TaskDTO taskDTO, @PathVariable Long taskId ){
       taskBusiness.modifyTask(taskId, taskDTO);
    }
}
