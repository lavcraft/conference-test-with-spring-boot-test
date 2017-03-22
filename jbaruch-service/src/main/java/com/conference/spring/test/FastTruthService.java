package com.conference.spring.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author tolkv
 * @version 20/03/2017
 */
@Slf4j
@Service
public class FastTruthService {

  @PostConstruct
  public void init() {
    log.info("I AM A FROG");
  }
}
