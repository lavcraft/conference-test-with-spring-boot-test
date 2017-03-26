package com.conference.spring.test.yegor256.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author tolkv
 * @version 23/03/2017
 */
@Data
@Builder
@AllArgsConstructor
public class Issuer {
  private final String name;
}
