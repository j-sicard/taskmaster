package com.taskmaster.taskmaster.reporitory;

import com.taskmaster.taskmaster.dto.TaskDTO;
import com.taskmaster.taskmaster.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT new com.taskmaster.taskmaster.dto.TaskDTO(t.id, t.description, t.deadline, t.user.id) " +
            "FROM Task t " +
            "WHERE t.user.id = :userId")
    List<TaskDTO> findTasksByUserId(@Param("userId") Long userId);



}
