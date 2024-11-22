package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.reporitory.TaskRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    // ----- createTask ----- //
    @Test
    @Transactional
    void createTask_shouldPersistTaskInRepository(){
        Task taskTest = new Task();
        taskTest.setDescription("Description for test");

        taskService.createdTask(taskTest);

        assertEquals(1, taskRepository.findAll().size());
    }

    @Test
    @Transactional
    void createTask_shouldPersistTaskWithCorrectDescription() {
        Task taskTest = new Task();
        taskTest.setDescription("Description for test");

        taskService.createdTask(taskTest);

        Task createdTask = taskRepository.findAll().get(0);
        assertEquals("Description for test", createdTask.getDescription());
    }

    // ----- findTasks ----- //
    @Test
    @Transactional
    void findTasks_shouldReturnAllTasks(){
        Task taskTest = new Task();
        taskService.createdTask(taskTest);

        assertEquals(1, taskService.findTasks().size());
    }

    // ----- findById ----- //

    @Test
    @Transactional
    void findTaskById_shouldReturnTaskWhenExists() {
        Task taskTest = new Task();
        taskTest.setDescription("Test description");
        taskService.createdTask(taskTest);

        assertTrue(taskService.findById(taskRepository.findAll().get(0).getId()).isPresent(), "Task should be found by its ID");
    }


}


