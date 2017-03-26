package com.conference.spring.test.webassistant.client;

import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author tolkv
 * @version 23/03/2017
 */
@FeignClient(name = "assistant", url = "${conference.assistant.url}")
public interface AssistantClient {
  @RequestMapping(value = "/answer", method = POST)
  Response answer(Answer answer);
}

/**
 * assistant start:
 *   - bootstrap
 *   - register in service discovery service <-- send spring.application.name=assistant
 *
 * service discovery:
 *  assistant:
 *   - assistant_{random.int}/host1:port0
 *   - assistant_{random.int}/host2:port1
 *   - assistant_{random.int}/host2:port2
 *
 *  yegor256-service
 *   - yegor256_уверенный/host:port
 *   - yegor256_неоченьуверенный/host:port
 *   - yegor256_крайненеуверенный/host:port
 *
 * -assistant-> service_discovery
 * <-- host1:port0 host2:port1 host2:port2
 * | RibbonLoadBalancer(host1:port0 host2:port1 host2:port2)
 *
 * 1. start app
 * 2. go to *discovery service* and fetch all `assistant` instances
 *  -> return assistant_1_host:9090,assistant_2_host:9091,assistant_3_host:9093
 * 3. configure Load Balancer
 */
