package com.taskmaster.taskmaster.service.impl;

import com.taskmaster.taskmaster.dto.TaskDTO;
import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.model.UserData;
import com.taskmaster.taskmaster.reporitory.TaskRepository;
import com.taskmaster.taskmaster.reporitory.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private ExpireTasksManagement expireTasksManagement;

    public void createTask(TaskDTO taskDTO, UserData user) {
            Task task = new Task();
            task.setDescription(taskDTO.getDescription());
            task.setDeadline(taskDTO.getDeadline());
            task.setUser(user);
            taskRepository.save(task);
    }




    public Boolean deleteTaskById(Long id){
        if (!taskRepository.findById(id).isEmpty()){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<TaskDTO>  findAllTaskByUserId(Long userId){
        return taskRepository.findTasksByUserId(userId);
    }

    public void modifyTaskById(Long taskId, TaskDTO taskModify) {
        Task originalTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task with ID " + taskId + " not found"));

        if (taskModify.getDescription() != null && !taskModify.getDescription().isEmpty()) {
            originalTask.setDescription(taskModify.getDescription());
        }
        if (taskModify.getDeadline() != null && !taskModify.getDeadline().equals(originalTask.getDeadline())) {
            originalTask.setDeadline(taskModify.getDeadline());
        }
        taskRepository.save(originalTask);
    }

}
