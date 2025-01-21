package com.taskmaster.taskmaster.business;

import com.taskmaster.taskmaster.dto.TaskDTO;
import com.taskmaster.taskmaster.model.Task;

import java.util.List;

public interface TaskBusiness {

    public String createdTask(TaskDTO taskDTO);

    public String deleteTaskById(Long taskId);

    public List<TaskDTO> getTasksByUserId(Long userId);

    public void modifyTask(Long taskId, TaskDTO taskModify);
}
