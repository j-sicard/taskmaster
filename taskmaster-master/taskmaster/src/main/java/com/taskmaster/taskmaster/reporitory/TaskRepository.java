package com.taskmaster.taskmaster.reporitory;

import com.taskmaster.taskmaster.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUser_UserId(Long userId);


}
