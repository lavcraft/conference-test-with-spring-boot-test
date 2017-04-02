package com.conference.spring.test.webassistant.jpa;

import com.conference.spring.test.webassistant.AssistantProperties;
import com.conference.spring.test.webassistant.persistence.AnswerDatabasePopulator;
import com.conference.spring.test.webassistant.persistence.AnswersRepository;
import com.conference.spring.test.webassistant.service.DefaultAssistantJpaBackend;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author tolkv
 * @version 28/03/2017
 */
@TestConfiguration
public class DefaultAssistantConfiguration {

  @Bean
  public AssistantProperties assistantProperties() {
    return new AssistantProperties(new ArrayList<>(Arrays.asList("random1", "random2", "random3")));
  }

  @Bean
  AnswerDatabasePopulator answerDatabasePopulator(AnswersRepository answersRepository,
                                                  AssistantProperties assistantProperties) {
    return new AnswerDatabasePopulator(answersRepository, assistantProperties);
  }

  @Bean
  @DependsOn("answerDatabasePopulator")
  DefaultAssistantJpaBackend defaultAssistantJpaBackend(AnswersRepository answersRepository) {
    return new DefaultAssistantJpaBackend(answersRepository);
  }
}
