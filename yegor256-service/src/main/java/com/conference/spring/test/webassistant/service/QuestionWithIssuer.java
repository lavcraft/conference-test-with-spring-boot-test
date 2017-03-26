package com.conference.spring.test.webassistant.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author tolkv
 * @version 22/03/2017
 */
@Data
@Builder
@AllArgsConstructor
public class QuestionWithIssuer {
  private final Question question;
  private final Issuer issuer;
}
