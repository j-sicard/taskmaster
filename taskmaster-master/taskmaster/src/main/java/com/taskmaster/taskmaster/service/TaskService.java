package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.dto.TaskDTO;
import com.taskmaster.taskmaster.model.UserData;

import java.util.List;

public interface TaskService {

    public void createTask(TaskDTO taskDTO, UserData user);

    public Boolean deleteTaskById(Long id);

    public List<TaskDTO>  findAllTaskByUserId(Long userId);

    public void modifyTaskById(Long taskId, TaskDTO taskModify);

}
