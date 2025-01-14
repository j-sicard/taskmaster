package com.taskmaster.taskmaster.service.impl;

import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.reporitory.TaskRepository;
import com.taskmaster.taskmaster.service.TaskService;
import com.taskmaster.taskmaster.utils.ExpireTasksManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ExpireTasksManagement pastTaskManagement;

    public void createTask(Task task){
        taskRepository.save(task);
    }

       public List<Task> findTasks(){
        List<Task> tasks = taskRepository.findAll();
       pastTaskManagement.deleteExpiredTasks();
        return tasks;
    }

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }

    public Boolean deleteTaskById(Long id){
        if (!taskRepository.findById(id).isEmpty()){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
