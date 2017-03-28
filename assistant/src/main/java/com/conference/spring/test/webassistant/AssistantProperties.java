package com.conference.spring.test.webassistant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author tolkv
 * @version 28/03/2017
 */
@Data
@ConfigurationProperties(prefix = "assistant.default")
public class AssistantProperties {
  private List<String> answers;
}
