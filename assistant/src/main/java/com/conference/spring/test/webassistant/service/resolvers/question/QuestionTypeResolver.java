package com.conference.spring.test.webassistant.service.resolvers.question;

import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.domain.QuestionType;

/**
 * @author tolkv
 * @version 23/02/2017
 */
public interface QuestionTypeResolver {
  QuestionType resolveType(Question question);
}
