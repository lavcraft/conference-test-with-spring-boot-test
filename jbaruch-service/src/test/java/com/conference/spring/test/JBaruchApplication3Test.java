package com.conference.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * @author tolkv
 * @version 19/03/2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
    classes = {TestConf.class},
    properties = {"uglyprop=f", "dfsd=fsdfds"})
@ActiveProfiles("test")
public class JBaruchApplication3Test {
  @Autowired
  ApplicationContext context;

//  @Value("${my.option}")
//  String val;

  @Test
  public void contextLoad() {

    Arrays.stream(context.getBeanDefinitionNames()).forEach(s -> System.out.println("s = " + s));
    System.out.println("context.getBeanDefinitionCount() = " + context.getBeanDefinitionCount());

//    MatcherAssert.assertThat(context, notNullValue());
//    MatcherAssert.assertThat(val, equalTo("hello-test"));
  }


}