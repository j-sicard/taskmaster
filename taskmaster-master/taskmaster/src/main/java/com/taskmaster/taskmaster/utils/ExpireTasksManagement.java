package com.taskmaster.taskmaster.utils;

import com.taskmaster.taskmaster.model.Task;

import java.util.List;

public interface ExpireTasksManagement {
    public Boolean isExpiredMoreThan24Hours(Task task);

    public void deleteExpiredTasks(List<Task> tasks) ;
}
