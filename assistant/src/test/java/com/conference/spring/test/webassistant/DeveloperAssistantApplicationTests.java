package com.conference.spring.test.webassistant;

import com.conference.spring.test.TestConfiguration1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfiguration1.class})
public class DeveloperAssistantApplicationTests {

  @Autowired
  ApplicationContext applicationContext;

  @Test
  public void contextLoads() {
    Assert.assertNotNull(applicationContext);
  }

}
