package com.taskmaster.taskmaster.business;

import com.taskmaster.taskmaster.dto.TaskDTO;

public interface TaskBusiness {

    public String createdTask(TaskDTO taskDTO);

    public String deleteTaskById(Long taskId);
}
