package com.taskmaster.taskmaster.business;

import com.taskmaster.taskmaster.dto.TaskDTO;
import com.taskmaster.taskmaster.reporitory.TaskRepository;
import com.taskmaster.taskmaster.service.TaskService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;


import static org.hibernate.validator.internal.util.Contracts.assertTrue;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
@Sql(scripts = "classpath:data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class TaskBusinessTest {

    @Autowired
    private TaskBusiness taskBusiness;

    @Autowired
    TaskRepository taskRepository;



    //-- createdTask --//
    @Test
    @Transactional
    void createdTaskSuccess(){
        int sizeBeforeTaskCreated = taskRepository.findTasksByUserId(8L).size();

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDescription("Description for test");
        taskDTO.setDeadline(LocalDateTime.now());
        taskDTO.setUserId(8L);

        taskBusiness.createdTask(taskDTO);

        assertTrue(taskRepository.findTasksByUserId(taskDTO.getUserId()).size() > sizeBeforeTaskCreated,
                "The size is not bigger of before the created task ");
    }

    @Test
    @Transactional
    void createdTaskFailed(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDescription("Description for test");
        taskDTO.setDeadline(LocalDateTime.now());
        taskDTO.setUserId(9L);

        assertTrue(taskBusiness.createdTask(taskDTO).equals("The user with ID 9 does not exist"),
                "the task was created incorrectly with the wrong userdata id");
    }

    //-- deleteTask --//
 @Autowired
    TaskService taskService;
    @Test
    @Transactional
    void deleteTaskSuccess(){
        assertTrue(taskBusiness.deleteTaskById(taskRepository.findTasksByUserId(10L).get(0).getTaskDtoId()) ==
                        "The task was successfully deleted","The task was not delete.");
    }

   //TODO Test exception of deleteTask
}
