package com.conference.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JBaruchApplicationTest2 {
  @Autowired
  ApplicationContext context;

  @Test
  public void invalidContextLoad() {
    assertThat(context, nullValue());
  }

}