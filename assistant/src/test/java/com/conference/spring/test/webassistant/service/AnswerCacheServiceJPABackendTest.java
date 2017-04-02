package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.persistence.AnswersRepository;
import com.conference.spring.test.webassistant.persistence.QuestionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tolkv
 * @version 02/04/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AnswerCacheServiceJPABackendTestConfiguration.class)
public class AnswerCacheServiceJPABackendTest {
  @Autowired
  AnswerCacheServiceJPABackend answerCacheServiceJPABackend;
  @Autowired
  AnswersRepository answersRepository;
  @Autowired
  QuestionRepository questionRepository;

  @Test
  public void should_miss_cache_if_db_is_down() throws Exception {
    answerCacheServiceJPABackend.find(Question.builder()
        .id("ID")
        .build());

    Mockito.verify(questionRepository, Mockito.times(1))
        .findFirstByText(Matchers.anyString());

  }
}