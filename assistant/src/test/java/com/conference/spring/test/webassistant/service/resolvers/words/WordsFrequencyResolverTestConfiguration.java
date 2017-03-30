package com.conference.spring.test.webassistant.service.resolvers.words;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author tolkv
 * @version 29/03/2017
 */
@Configuration
@ComponentScan({
    "com.conference.spring.test.webassistant.service.resolvers.words",
    "com.conference.spring.test.common"
})
public class WordsFrequencyResolverTestConfiguration {

}
