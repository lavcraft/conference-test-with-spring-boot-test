package com.conference.spring.test.webassistant.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tolkv
 * @version 23/02/2017
 */
@AllArgsConstructor
@Getter
public enum QuestionType {
  YEGOR256(false), JBARUCH(true), OTHER(true);

  private final boolean cacheable;
}