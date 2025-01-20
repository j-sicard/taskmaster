package com.taskmaster.taskmaster.business.impl;

import com.taskmaster.taskmaster.business.TaskBusiness;
import com.taskmaster.taskmaster.dto.TaskDTO;
import com.taskmaster.taskmaster.model.UserData;
import com.taskmaster.taskmaster.service.TaskService;
import com.taskmaster.taskmaster.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskBusinessImpl implements TaskBusiness {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserDataService userDataService;

    public String createdTask(TaskDTO taskDTO) {
        return userDataService.findUserDataById(taskDTO.getUserId())
                .map(user -> {
                    taskService.createTask(taskDTO, user);
                    return "Task created correctly";
                })
                .orElseGet(() -> "The user with ID " + taskDTO.getUserId() + " does not exist");
    }

    // TODO exception not tested
    public String deleteTaskById(Long taskId) {
        Boolean result = taskService.deleteTaskById(taskId);
        if (result.equals(true)) {
            return "The task was successfully deleted";
        }
        throw new RuntimeException("Failed to delete the task");
    }

    //TODO exception not created,
    //TODO if user null
    public void createTask(TaskDTO task){
        taskService.createTask(task, userDataService.findUserDataById(task.getUserId()).orElseGet(null));
    }

}
