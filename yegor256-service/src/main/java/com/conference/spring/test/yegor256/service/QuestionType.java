package com.conference.spring.test.yegor256.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author tolkv
 * @version 25/03/2017
 */
@RequiredArgsConstructor
@Getter
public enum QuestionType {
  YEGOR256(false), JBARUCH(true), OTHER(true);

  private final boolean cacheable;
}
