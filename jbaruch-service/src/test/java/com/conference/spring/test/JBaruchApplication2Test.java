package com.conference.spring.test;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * @author tolkv
 * @version 19/03/2017
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(
//    classes = {TestConfProp.class,TestConf.class},
//    properties = {"uglyprop=f", "dfsd=fsdfds"})
public class JBaruchApplication2Test {
  @Autowired
  ApplicationContext context;

  @Test
  public void contextLoad() {

    MatcherAssert.assertThat(context, notNullValue());
  }


}