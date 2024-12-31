package com.taskmaster.taskmaster.business.impl;

import com.taskmaster.taskmaster.business.TaskBusiness;
import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskBusinessImpl implements TaskBusiness {

    @Autowired
    TaskService taskService;

    public List<Task> findTasks(){
        return taskService.findTasks();
    }
}
