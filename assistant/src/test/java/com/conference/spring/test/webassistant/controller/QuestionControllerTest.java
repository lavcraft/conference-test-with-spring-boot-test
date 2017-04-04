package com.conference.spring.test.webassistant.controller;

import com.conference.spring.test.webassistant.client.JBaruchClient;
import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.service.NotificationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import static com.conference.spring.test.webassistant.domain.QuestionType.JBARUCH;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author tolkv
 * @version 03/04/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = QuestionControllerTest.MockJbaruchConfiguration.class,
    webEnvironment = RANDOM_PORT
)
public class QuestionControllerTest {
  @Autowired
  TestRestTemplate testRestTemplate;
  @Autowired
  JBaruchClient jBaruchClient;
  @MockBean
  NotificationService notificationService;
  @Captor
  ArgumentCaptor<Answer> argumentCaptor;

  @Test
  public void should_send_question() throws Exception {
    Mockito.doReturn(Answer.builder()
        .answer("Технологии идеальны, люди – ***ки")
        .build())
        .when(jBaruchClient).handleQuestion(anyObject());

    ResponseEntity<Question> questionResponseEntity = testRestTemplate.postForEntity("/question",
        Question.builder()
            .body("Технологии для людей?")
            .build()
        , Question.class);

    assertThat(questionResponseEntity.getStatusCode(), equalTo(OK));

    verify(notificationService, times(1)).notify(argumentCaptor.capture());

    assertThat(argumentCaptor.getValue().getAnswer(), equalTo("Технологии идеальны, люди – ***ки"));
  }

  @TestConfiguration
  public static class MockJbaruchConfiguration {
    @MockBean
    JBaruchClient jBaruchClient;

    @PostConstruct
    public void init() {
      when(jBaruchClient.assistantName())
          .thenReturn(JBARUCH);
    }
  }
}