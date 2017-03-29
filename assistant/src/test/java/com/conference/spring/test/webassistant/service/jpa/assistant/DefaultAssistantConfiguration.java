package com.conference.spring.test.webassistant.service.jpa.assistant;

import com.conference.spring.test.webassistant.AssistantProperties;
import com.conference.spring.test.webassistant.persistence.AnswerDatabasePopulator;
import com.conference.spring.test.webassistant.persistence.AnswersRepository;
import com.conference.spring.test.webassistant.service.DefaultAssistantJpaBackend;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

/**
 * @author tolkv
 * @version 28/03/2017
 */
@TestConfiguration
public class DefaultAssistantConfiguration {
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
