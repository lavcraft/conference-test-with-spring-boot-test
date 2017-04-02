package com.conference.spring.test.webassistant.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author tolkv
 * @version 03/04/2017
 */
@RunWith(SpringRunner.class)
@ComponentScan("com.conference.spring.test.webassistant")
@WebMvcTest
public class QuestionControllerTest {
  @Autowired
  MockMvc mockMvc;
//  @MockBean
//  NotificationService notificationService;
//  @MockBean
//  AssistantServiceJavaGuruBackend assistantServiceJavaGuruBackend;
//  @MockBean
//  QuestionTypeResolver questionTypeResolver;

  @Test
  public void should_send_question() throws Exception {
    mockMvc.perform(
        post("/question")
            .content("{ \"body\":\"Что нужно сделать чтобы было артифактори работал нормально?\"}")
            .accept("application/json")
            .contentType("application/json")
    ).andExpect(status().isOk());
  }
}