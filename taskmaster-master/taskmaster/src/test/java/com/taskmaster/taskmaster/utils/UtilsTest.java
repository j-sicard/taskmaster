package com.taskmaster.taskmaster.utils;

import com.taskmaster.taskmaster.model.Task;
import com.taskmaster.taskmaster.reporitory.TaskRepository;
import com.taskmaster.taskmaster.service.TaskService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilsTest {

    @Autowired
    ExpireTasksManagement expireTasksManagement;

    @Autowired
    private TaskRepository taskRepository;

    private Task taskTest;


    @BeforeEach
    public void setUp() {
        taskTest = new Task();
        taskTest.setDescription("Description for test");
        taskRepository.save(taskTest);
    }

    @Test
    @Transactional
    void isExpiredMoreThan24HoursTest(){

    }
}
