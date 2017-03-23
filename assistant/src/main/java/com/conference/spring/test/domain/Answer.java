package com.conference.spring.test.domain;

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
  String id;
  String operatorId;
  String answer;

  Question question;
}
