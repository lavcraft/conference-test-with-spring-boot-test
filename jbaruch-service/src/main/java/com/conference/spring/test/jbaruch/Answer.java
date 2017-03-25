package com.conference.spring.test.jbaruch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@Data
@Builder
@AllArgsConstructor
public class Answer {
  private String id;
  private String operatorId;
  private String answer;

  private String questionId;
}
