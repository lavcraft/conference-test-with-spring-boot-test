package com.conference.spring.test.yegor256.service;

import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.webassistant.domain.QuestionType;

/**
 * @author tolkv
 * @version 23/02/2017
 */
public interface QuestionTypeResolver {
  QuestionType resolveType(Question question);
}
