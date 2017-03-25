package com.conference.spring.test;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Yegor256ApplicationTest {
  @Autowired
  private ApplicationContext context;

  @Test
  public void test() {
    MatcherAssert.assertThat(context, notNullValue());
  }
}