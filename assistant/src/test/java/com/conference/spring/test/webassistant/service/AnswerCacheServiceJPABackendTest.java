package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.persistence.AnswersRepository;
import com.conference.spring.test.webassistant.persistence.QuestionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @author tolkv
 * @version 02/04/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnswerCacheServiceJPABackendTestConfiguration.class)
public class AnswerCacheServiceJPABackendTest {
  @Autowired
  AnswerCacheServiceJPABackend answerCacheServiceJPABackend;

  @MockBean
  QuestionRepository questionRepository;
  @MockBean
  AnswersRepository answersRepository;

  @Test
  public void should_miss_cache_if_db_is_down() throws Exception {

    doThrow(new RuntimeException("Database is down")).when(answersRepository).findAll();
    doThrow(new RuntimeException("Database is down")).when(questionRepository).findAll();

    Answer answer = answerCacheServiceJPABackend.find(Question.builder()
        .id("ID")
        .build());

    verify(questionRepository, times(1))
        .findFirstByText(anyString());

    assertNull(answer);
  }
}