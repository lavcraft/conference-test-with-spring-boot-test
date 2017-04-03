package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.webassistant.persistence.AnswersRepository;
import com.conference.spring.test.webassistant.persistence.QuestionRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author tolkv
 * @version 02/04/2017
 */
@TestConfiguration
public class AnswerCacheServiceJPABackendTestConfiguration {

  @Bean
  public AnswerCacheServiceJPABackend answerCacheServiceJpaBackend(QuestionRepository questionRepository, AnswersRepository answerRepository) {
    return new AnswerCacheServiceJPABackend(questionRepository, answerRepository);
  }
}