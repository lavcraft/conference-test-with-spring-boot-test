package com.conference.spring.test.common;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author tolkv
 * @version 29/03/2017
 */
@Component
@NoArgsConstructor
@PropertySource("classpath:user.properties")
public class GarbageProperties {
  @Getter
  private List<String> garbage;

  @Value("${garbage}")
  void setGarbage(String[] garbage) {
    this.garbage = Arrays.asList(garbage);
  }
}
