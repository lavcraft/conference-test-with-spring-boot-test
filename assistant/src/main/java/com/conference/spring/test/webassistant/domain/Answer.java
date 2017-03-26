package com.conference.spring.test.webassistant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author tolkv
 * @version 23/02/2017
 */
@Data
@Builder
@AllArgsConstructor
public class Answer {
  private String id;
  private String operatorId;
  private String answer;
  private String answerDate;

  private String questionId;
}
