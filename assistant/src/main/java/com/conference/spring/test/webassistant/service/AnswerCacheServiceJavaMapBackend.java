package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.help.QuestionAnswerHelper;
import com.conference.spring.test.webassistant.persistence.AnswerEntity;
import com.conference.spring.test.webassistant.persistence.AnswersRepository;
import com.conference.spring.test.webassistant.persistence.QuestionEntity;
import com.conference.spring.test.webassistant.persistence.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.conference.spring.test.webassistant.help.QuestionAnswerHelper.mapToAnswerEntity;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@Service
@RequiredArgsConstructor
public class AnswerCacheServiceJavaMapBackend implements AnswerCacheService {
  private final QuestionRepository questionRepository;
  private final AnswersRepository answersRepository;

  @Override
  public Answer find(Question question) {
    try {
      return questionRepository.findFirstByText(question.getBody())
          .map(QuestionAnswerHelper::mapToAnswer)
          .orElseGet(null);
    } catch (Throwable e) {
      return null;
    }
  }

  @Override
  @Transactional
  public void put(String questionId, Answer answer) {
    AnswerEntity persistedAnswer = answersRepository.save(mapToAnswerEntity(answer));
    questionRepository.setAnswerFor(persistedAnswer, questionId);
  }

  @Override
  public Optional<Question> put(Question question) {
    QuestionEntity questionEntity = QuestionEntity.builder()
        .id(question.getId())
        .text(question.getBody())
        .questionType(question.getQuestionType())
        .userId(question.getUserId())
        .build();
    return Optional.ofNullable(questionRepository.save(questionEntity))
        .map(QuestionAnswerHelper::mapToQuestion);
  }

}
