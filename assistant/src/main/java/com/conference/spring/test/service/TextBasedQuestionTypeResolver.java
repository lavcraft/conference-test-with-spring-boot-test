package com.conference.spring.test.service;

import com.conference.spring.test.domain.Question;
import com.conference.spring.test.domain.QuestionType;

import java.util.Arrays;

/**
 * @author tolkv
 * @version 23/02/2017
 */
public class TextBasedQuestionTypeResolver implements QuestionTypeResolver {
  @Override
  public QuestionType resolveType(Question question) {
    return Arrays.stream(QuestionType.values())
        .filter(questionType -> question.getBody().toLowerCase()
            .contains(
                questionType.toString().toLowerCase()
            )
        )
        .findAny()
        .orElse(QuestionType.OTHER);


  }
}
