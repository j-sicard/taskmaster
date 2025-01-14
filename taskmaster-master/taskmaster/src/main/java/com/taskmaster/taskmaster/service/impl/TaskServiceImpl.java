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
    private TaskRepository taskRepository;

    @Autowired
    private ExpireTasksManagement expireTasksManagement;

    public void createTask(Task task){
        taskRepository.save(task);
    }

    public Boolean deleteTaskById(Long id){
        if (!taskRepository.findById(id).isEmpty()){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Task> findAndCleanTasksByUserId(Long userId){
        List<Task> tasks = taskRepository.findAllByUser_UserId(userId);
        expireTasksManagement.deleteExpiredTasks(tasks);

        return tasks;
    }
}
