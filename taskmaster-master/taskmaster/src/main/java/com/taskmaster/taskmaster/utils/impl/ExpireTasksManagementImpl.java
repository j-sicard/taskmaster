package com.taskmaster.taskmaster.utils.impl;

import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.reporitory.TaskRepository;
import com.taskmaster.taskmaster.utils.ExpireTasksManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


@Component
public  class ExpireTasksManagementImpl implements ExpireTasksManagement {

    @Autowired
    TaskRepository taskRepository;

     public Boolean isExpiredMoreThan24Hours(Task task){
         LocalDateTime date = task.getDeadline();
         Duration duration = Duration.between(date, LocalDateTime.now());

         return duration.toHours() > 24;
    }

    public void deleteExpiredTasks(List<Task> tasks) {
        tasks.stream()
                .filter(this::isExpiredMoreThan24Hours)
                .forEach(taskRepository::delete);
    }




}
