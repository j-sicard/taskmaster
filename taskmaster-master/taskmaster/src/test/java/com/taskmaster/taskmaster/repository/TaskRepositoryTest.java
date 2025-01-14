package com.taskmaster.taskmaster.repository;
import com.taskmaster.taskmaster.reporitory.TaskRepository;
import com.taskmaster.taskmaster.reporitory.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
@Sql(scripts = "classpath:data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void findAllByUserIdForUser1Test() {
        assertTrue(taskRepository.findAllByUser_UserId(1L).size() == 2);
    }

    @Test
    void findAllByUserIdForUser2Test() {
        System.out.println("THE SIZE OF USER 2 TASK IS =>" + taskRepository.findAllByUser_UserId(2L).size());
        assertTrue(taskRepository.findAllByUser_UserId(2L).size() == 3);
    }

    @Test
    void shouldReturnTaskWithGivenDescription_whenFindAllByUserIdIndex_0_ListTest(){
        assertTrue(taskRepository.findAllByUser_UserId(3L).get(0).getDescription().equals("Return description N°1"));
    }

    @Test
    void shouldReturnTasksWithGivenDeadLine_WhenFindAllByUserIdIndex_0_ListTest() {
       assertTrue(taskRepository.findAllByUser_UserId(4L).get(0).getDeadline().equals(LocalDateTime.parse("2011-11-11T11:11")));
    }

    @Test
    void shouldReturnTasksWithGivenUserName_WhenFindAllByUserIdIndex_0_ListTest() {
        assertTrue(taskRepository.findAllByUser_UserId(5L).get(0).getUser().getUserName().equals("User 5"));
    }
}
