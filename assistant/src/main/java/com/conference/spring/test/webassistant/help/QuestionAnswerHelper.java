package com.conference.spring.test.webassistant.help;

import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.persistence.AnswerEntity;
import com.conference.spring.test.webassistant.persistence.QuestionEntity;

/**
 * @author tolkv
 * @version 02/04/2017
 */
public class QuestionAnswerHelper {
  public static Answer mapToAnswer(QuestionEntity questionEntity) {
    AnswerEntity answerEntity = questionEntity.getAnswer();
    return mapToAnswer(questionEntity, answerEntity);
  }

  public static Answer mapToAnswer(QuestionEntity questionEntity, AnswerEntity answerEntity) {
    return Answer.builder()
        .id(answerEntity.getId())
        .operatorId(answerEntity.getOperatorId())
        .answer(answerEntity.getText())
        .questionId(questionEntity.getId())
        .build();
  }

  public static AnswerEntity mapToAnswerEntity(Answer answer) {
    return AnswerEntity.builder()
        .text(answer.getAnswer())
        .id(answer.getId())
        .operatorId(answer.getOperatorId())
        .build();
  }

  public static Question mapToQuestion(QuestionEntity q) {
    return Question.builder()
        .body(q.getText())
        .id(q.getId())
        .userId(q.getUserId())
        .questionType(q.getQuestionType())
        .build();
  }
}
