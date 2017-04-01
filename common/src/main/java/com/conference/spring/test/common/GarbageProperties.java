package com.conference.spring.test.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

/**
 * @author tolkv
 * @version 29/03/2017
 */
@NoArgsConstructor
public class GarbageProperties {
  @Getter
  private List<String> garbage;

  @Value("${garbage}")
  void setGarbage(String[] garbage) {
    this.garbage = Arrays.asList(garbage);
  }
}
