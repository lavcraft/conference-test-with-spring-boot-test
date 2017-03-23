package com.conference.spring.test.service;

import com.conference.spring.test.domain.Answer;
import com.conference.spring.test.domain.Question;

import java.util.Optional;

/**
 * Если вопрос уже задавали Баруху - не отправляем, он человек слова, не передумает. Поэтому у баруха нет очереди, но есть кэш
 *  А Егору отправляем всегда, он может передумать, он всегда в поисках истины. Есть очередь но нет кэша
 * @author tolkv
 * @version 23/02/2017
 */
public interface AnswerCacheService {

  Optional<Answer> find(Question question);

}
