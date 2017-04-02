package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.webassistant.persistence.AnswersRepository;
import com.conference.spring.test.webassistant.persistence.QuestionRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.doThrow;

/**
 * @author tolkv
 * @version 02/04/2017
 */
@TestConfiguration
//@SpringBootConfiguration
//@MockBean(QuestionRepository.class)
//@MockBean(AnswersRepository.class)
public class AnswerCacheServiceJPABackendTestConfiguration {
  @MockBean
  QuestionRepository questionRepository;
  @MockBean
  AnswersRepository answersRepository;

  @Bean
  public AnswerCacheServiceJPABackend answerCacheServiceJpaBackend(QuestionRepository questionRepository, AnswersRepository answerRepository) {
    doThrow(new RuntimeException("Database is down")).when(answerRepository).findAll();
    doThrow(new RuntimeException("Database is down")).when(questionRepository).findAll();
    return new AnswerCacheServiceJPABackend(questionRepository, answerRepository);
  }
}