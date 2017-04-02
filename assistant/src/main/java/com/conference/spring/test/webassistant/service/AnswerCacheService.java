package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;

import java.util.Optional;

/**
 * Если вопрос уже задавали Баруху - не отправляем, он человек слова, не передумает. Поэтому у баруха нет очереди, но есть кэш
 *  А Егору отправляем всегда, он может передумать, он всегда в поисках истины. Есть очередь но нет кэша
 * @author tolkv
 * @version 23/02/2017
 */
public interface AnswerCacheService {

  Answer find(Question question);

  void put(String questionId, Answer answer);
  Optional<Question> put(Question question);
}
