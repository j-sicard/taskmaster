package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.reporitory.TaskRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(value = "test")
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    private Task taskTest;


    // ----- findTasks ----- //
    @Test
    @Transactional
    void findTasks_shouldReturnAllTasks() {
        assertEquals(1, taskService.findTasks().size(), "The method findTasks should return 1 task.");
    }

    // ----- createTask ----- //
    @Test
    @Transactional
    void createTask_shouldPersistTaskInRepository() {
        int tasksSizeBeforeCreateTaskForTest = taskRepository.findAll().size();

        Task taskForCreateTaskTest = new Task();
        taskForCreateTaskTest.setDescription("Description for create Task Test");

        taskService.createTask(taskForCreateTaskTest);

        assertTrue(taskRepository.findAll().size() > tasksSizeBeforeCreateTaskForTest,
                "The repository should contain 1 more Task.");
    }

    @Test
    @Transactional
    void createTask_shouldPersistTaskWithCorrectDescription() {
        assertEquals("Description for test", taskRepository.findAll().get(0).getDescription(), "The description of the created task is incorrect.");
    }

    // ----- findById ----- //
    @Test
    @Transactional
    void findTaskById_shouldReturnTaskWhenExists() {
        Task foundTask = taskService.findById(taskTest.getTaskId()).orElse(null);
        assertNotNull(foundTask, "The task was not found by ID.");
        assertEquals("Description for test", foundTask.getDescription(), "The task description found is incorrect.");
    }

    // ----- deleteTaskById ----- //
    @Test
    @Transactional
    void deleteTaskByIdTest() {
        assertTrue(taskService.findTasks().contains(taskTest), "taskTest should exist before deletion.");

        taskService.deleteTaskById(taskTest.getTaskId());

        assertFalse(taskService.findTasks().contains(taskTest), "taskTest should no longer exist after deletion.");
    }
}


