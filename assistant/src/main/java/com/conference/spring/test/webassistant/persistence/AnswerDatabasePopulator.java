package com.conference.spring.test.webassistant.persistence;

import com.conference.spring.test.webassistant.AssistantProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;

/**
 * @author tolkv
 * @version 28/03/2017
 */
@RequiredArgsConstructor
@Component(AnswerDatabasePopulator.DATABASE_ANSWER_POPULATOR)
public class AnswerDatabasePopulator {
  public static final String DATABASE_ANSWER_POPULATOR = "database.answer.populator";
  private final AnswersRepository answersRepository;
  private final AssistantProperties assistantProperties;

  @PostConstruct
  public void init() {
    answersRepository.save(
        assistantProperties.getAnswers().stream().map(s -> AnswerEntity.builder()
            .text(s)
            .build()).collect(Collectors.toList())
    );
  }
}
