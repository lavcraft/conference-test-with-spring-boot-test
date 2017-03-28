package com.conference.spring.test.webassistant.delete;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author tolkv
 * @version 28/03/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextHierarchy({
    @ContextConfiguration(classes = {Config1.class}),
    @ContextConfiguration(classes = {Config3.class}),
})
public class ConfigTest2 {

  @Test
  public void haha2() throws Exception {
    System.out.println("2test");
    assertThat(true, equalTo(true));
  }

}
