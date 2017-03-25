package com.conference.spring.test.jbaruch;

import lombok.Builder;
import lombok.experimental.Delegate;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@Builder
public class AnswerResponse {
  @Delegate Answer answer;
}

