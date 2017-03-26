package com.conference.spring.test.yegor256.service;

import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;

/**
 * Если тип java - отправляем в очередь к Егору
 * Если тип groovy - отправляем напрямую к Баруху, ему очередь не нужна, и так быстро отвечает
 *
 * Откуда появляются очереди?
 * Очереди появляются когда нет кэша (см шутка про очередь егора и баруха)
 *
 * Сначала про
 * @author tolkv
 * @version 23/02/2017
 */
public interface AssistantService {
  Answer handleQuestion(Question question);
}
