package com.conference.spring.test.jbaruch;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = MOCK)
public class JBaruchApplicationTest {
  @Autowired
  ApplicationContext context;

  @Autowired
  JBaruchProperties jBaruchProperties;

  @Test
  public void contextLoad() {
    Assert.assertThat(jBaruchProperties.getAnswers().size(), Matchers.greaterThan(5));
    MatcherAssert.assertThat(context, notNullValue());
  }


}