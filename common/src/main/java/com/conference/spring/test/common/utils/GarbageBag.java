package com.conference.spring.test.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 25/03/2017.
 */
@PropertySource("classpath:user.properties")
@Component
public class GarbageBag {
    public List<String> garbage;

    @Value("${garbage}")
    private void setGarbage(String[] garbage) {
        this.garbage = Arrays.asList(garbage);
    }

}
