package com.conference.spring.test.jbaruch;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author tolkv
 * @version 26/03/2017
 */
@Data
@ConfigurationProperties(prefix = "jbaruch")
public class JBaruchProperties {
  List<String> answers;
}
