package com.conference.spring.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author tolkv
 * @version 20/03/2017
 */
@Slf4j
@Configuration
@ComponentScan
public class TestConf {

  @PostConstruct
  public void init(){
    log.info("NOTAFROG2");
  }

  @Bean(name = "test.string")
  public String string() {
    return "DSDSA";
  }

}
