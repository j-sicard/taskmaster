package com.taskmaster.taskmaster.bo;

import com.taskmaster.taskmaster.model.Task;

public class TaskAndStatus {

    private Task task;

    private String status;

    public TaskAndStatus(Task task, String status) {
        this.task = task;
        this.status = status;
    }

    public TaskAndStatus() {
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }  @Override
    public String toString() {
        return "TaskAndStatus{" +
                "task=" + task +
                ", status='" + status + '\'' +
                '}';
    }


}
