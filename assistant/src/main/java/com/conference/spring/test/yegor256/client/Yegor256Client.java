package com.conference.spring.test.yegor256.client;

import com.conference.spring.test.webassistant.domain.Answer;
import com.conference.spring.test.webassistant.domain.Question;
import com.conference.spring.test.yegor256.service.AssistantService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tolkv
 * @version 22/03/2017
 */
@FeignClient(name = "yegor256-service", url = "${conference.yegor256.url}")
public interface Yegor256Client extends AssistantService {
  @Override
  @RequestMapping(path = "/question", method = RequestMethod.POST)
  Answer handleQuestion(Question question);
}
