package com.conference.spring.test.webassistant.client;

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
  String id;
  String operatorId;
  String answer;

  String questionId;
}
