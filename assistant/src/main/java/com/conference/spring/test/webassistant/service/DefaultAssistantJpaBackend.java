package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.common.utils.IconConstants;
import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.domain.QuestionType;
import com.conference.spring.test.webassistant.persistence.AnswerDatabasePopulator;
import com.conference.spring.test.webassistant.persistence.AnswerEntity;
import com.conference.spring.test.webassistant.persistence.AnswersRepository;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author tolkv
 * @version 28/03/2017
 */
@Service
@DependsOn(AnswerDatabasePopulator.DATABASE_ANSWER_POPULATOR)
public class DefaultAssistantJpaBackend implements AssistantService {
  private final AnswersRepository answersRepository;
  private final List<Answer> answers;

  public DefaultAssistantJpaBackend(AnswersRepository answersRepository) {
    this.answersRepository = answersRepository;
    answers = new ArrayList<>();
    Iterable<AnswerEntity> all = answersRepository.findAll();
    for (AnswerEntity answerEntity : all) {
      answers.add(Answer.builder()
          .answer(answerEntity.getText())
          .operatorId(IconConstants.SKULL_ICON)
          .id(answerEntity.getId())
          .build());
    }
  }

  @Override
  public Answer handleQuestion(Question question) {
    return getRandomAnswer();
  }

  @Override
  public QuestionType assistantName() {
    return QuestionType.OTHER;
  }

  private Answer getRandomAnswer() {
    int randomAnswerIndex = ThreadLocalRandom.current().nextInt(answers.size());
    return answers.get(randomAnswerIndex);
  }

}
