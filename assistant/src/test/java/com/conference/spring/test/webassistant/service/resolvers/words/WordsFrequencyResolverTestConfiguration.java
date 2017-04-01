package com.conference.spring.test.webassistant.service.resolvers.words;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author tolkv
 * @version 29/03/2017
 */
@TestConfiguration
//@Import(WordsCommonConfiguration.class)
@ComponentScan({
    "com.conference.spring.test.webassistant.service.resolvers.words"
})
public class WordsFrequencyResolverTestConfiguration {

}
