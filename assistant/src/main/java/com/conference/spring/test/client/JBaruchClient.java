package com.conference.spring.test.client;

import com.conference.spring.test.domain.Answer;
import com.conference.spring.test.domain.Question;
import com.conference.spring.test.service.AssistantService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tolkv
 * @version 22/03/2017
 */

@FeignClient(name = "jbaruch-service", url = "${conference.jbaruch.url}")
public interface JBaruchClient extends AssistantService {
  @Override
  @RequestMapping(path = "/question", method = RequestMethod.POST)
  Answer handleQuestion(Question question);
}
