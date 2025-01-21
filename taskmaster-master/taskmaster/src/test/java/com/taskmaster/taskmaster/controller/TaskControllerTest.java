package com.taskmaster.taskmaster.controller;

import com.taskmaster.taskmaster.dto.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;


@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
@Sql(scripts = "classpath:data-test.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    TaskController taskController;

  @Autowired
  public  MockMvc mockMvc;


  // -- getTasksByUserId -- //
  @Test
  void getTask_ShouldIfStatusOkTest() throws Exception{
      mockMvc.perform(MockMvcRequestBuilders.get("/task/tasks/11")
              .contentType(MediaType.APPLICATION_JSON)).andExpect(
              MockMvcResultMatchers.status().isOk()
      );
  }

  //TODO continue the test for status 404
    // TODO this exception not created in controller

  /*  @Test
    void getTaskTest_NotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/task/tasks/12")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }*/

    // -- deleteTaskById -- //

    @Test
    void deleteTaskById_shouldIfStatusOkTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/task/delete/16")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(
                MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    void deleteTaskById_shouldIfStatusNotFound() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/task/delete/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}

