package com.conference.spring.test.yegor256;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author tolkv
 * @version 26/03/2017
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "yegor256")
public class Yegor256Properties {
  List<String> answers;
}
