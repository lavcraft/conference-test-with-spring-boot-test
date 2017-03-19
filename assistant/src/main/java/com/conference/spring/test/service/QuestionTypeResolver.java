package com.conference.spring.test.service;

import com.conference.spring.test.domain.Question;
import com.conference.spring.test.domain.QuestionType;

/**
 * @author tolkv
 * @version 23/02/2017
 */
public interface QuestionTypeResolver {
  QuestionType resolveType(Question question);
}
