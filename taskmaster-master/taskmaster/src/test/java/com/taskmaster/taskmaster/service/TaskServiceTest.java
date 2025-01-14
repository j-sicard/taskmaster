package com.taskmaster.taskmaster.service;

import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.model.UserData;
import com.taskmaster.taskmaster.reporitory.TaskRepository;
import com.taskmaster.taskmaster.reporitory.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
@Sql(scripts = "classpath:data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @BeforeAll
    public void CreateTaskForTest(){
        Optional<UserData> optionalUser = userRepository.findById(7L);

        if (optionalUser.isPresent()) {
            UserData user = optionalUser.get();
            Task task = new Task();
            task.setUser(user);
            task.setDescription("New task for test");
            task.setDeadline(LocalDateTime.now());
            taskService.createTask(task);
        } else {
            throw new IllegalArgumentException("The userData with the ID " + optionalUser.get().getUserId() + "  doesn't exist");
        }
    }



    // ----- createTask ----- //

    @Test
    @Transactional
    void createTask_shouldPersistTaskInRepository() {
       assertTrue(taskRepository.findAllByUser_UserId(7L).size() == 1, "after you create optionalUser The DataBase contain tasks for this User ");
    }

    @Test
    @Transactional
    void createTask_shouldPersistTaskDescriptionInRepository() {
        assertTrue(taskRepository.findAllByUser_UserId(7L).get(0).getDescription() == ("New task for test"), "after you create optionalUser The DataBase contain tasks for this User ");
    }

    // ----- deleteTaskById ----- //
    @Test
    void deleteTaskByIdTest() {
        List<Task> tasks = taskRepository.findAllByUser_UserId(6L);
        assertTrue(tasks.size() == 1 , "The task number for user 6 before the delete is different");

        taskService.deleteTaskById(tasks.get(0).getTaskId());

        assertTrue(taskRepository.findAllByUser_UserId(6L).size() == 0, "The task number for user 6 before the after is different");
    }
}


