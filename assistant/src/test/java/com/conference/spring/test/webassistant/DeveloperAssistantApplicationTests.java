package com.conference.spring.test.webassistant;

import com.conference.spring.test.webassistant.service.resolvers.words.Yegor256WordsFrequencyResolver;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeveloperAssistantApplicationTests {
  @Autowired
  Yegor256WordsFrequencyResolver yegor256WordsFrequencyResolver;

  @Autowired
  ApplicationContext applicationContext;

  @Test
  public void contextLoads() {
    Assert.assertNotNull(applicationContext);
  }

}
