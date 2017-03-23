package com.conference.spring.test.client;

import com.conference.spring.test.domain.Answer;
import com.conference.spring.test.domain.Question;
import com.conference.spring.test.service.AssistantService;

/**
 * @author tolkv
 * @version 22/03/2017
 */
public class JBaruchClient implements AssistantService {
  @Override
  public Answer handleQuestion(Question question) {
    return Answer.builder()
        .answer("I AM FROG")
        .build();
  }
}
