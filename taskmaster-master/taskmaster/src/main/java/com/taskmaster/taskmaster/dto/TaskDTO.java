package com.taskmaster.taskmaster.dto;

import java.time.LocalDateTime;

public class TaskDTO {

   private Long taskDtoId;
   private String description;
   private LocalDateTime deadline;
   private Long userId;

   public TaskDTO(Long id, String description, LocalDateTime deadline, Long userId) {
      this.taskDtoId = id;
      this.description = description;
      this.deadline = deadline;
      this.userId = userId;
   }

   public TaskDTO() {
   }

   public Long getTaskDtoId() {
      return taskDtoId;
   }

   public void setTaskDtoId(Long taskDtoId) {
      this.taskDtoId = taskDtoId;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public LocalDateTime getDeadline() {
      return deadline;
   }

   public void setDeadline(LocalDateTime deadline) {
      this.deadline = deadline;
   }

   public Long getUserId() {
      return userId;
   }

   public void setUserId(Long userId) {
      this.userId = userId;
   }

   @Override
   public String toString() {
      return "TaskDTO{" +
              "id=" + taskDtoId +
              ", description='" + description + '\'' +
              ", deadline=" + deadline +
              ", userId=" + userId +
              '}';
   }
}
