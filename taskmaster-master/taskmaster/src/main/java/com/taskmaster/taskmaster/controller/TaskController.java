package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    ResponseEntity<List<Task>> getTasks(){
        return new ResponseEntity<>(taskService.findTasks(), HttpStatus.OK);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        Optional<Task> task = taskService.findById(taskId);

        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PostMapping("/new")
    void newTask(@RequestBody Task newTask){
       taskService.createTask(newTask);
    }

    @DeleteMapping("/delete/{taskId}")
    ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        if (taskService.deleteTaskById(taskId)) {
            return ResponseEntity.ok("Task " + taskId + " deleted.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task " + taskId + " not found.");
    }

}
