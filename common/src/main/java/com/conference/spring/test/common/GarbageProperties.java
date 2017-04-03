package com.conference.spring.test.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
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

    List<String> enGarbage = Arrays.asList(garbage);
    List<String> ruGarbage = Arrays.asList("а", "или", "не", "и", "да", "но", "если");

    this.garbage = new ArrayList<>();
    this.garbage.addAll(enGarbage);
    this.garbage.addAll(ruGarbage);
  }
}
