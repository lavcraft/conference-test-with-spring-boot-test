package com.conference.spring.test.webassistant.service;

import com.conference.spring.test.common.utils.WordsUtil;
import com.conference.spring.test.webassistant.domain.Question;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 28/03/2017.
 */
public abstract class AbstractWordsFrequencyResolver implements WordsFrequencyResolver {
    @Override
    public int match(Question question) {
        return (int) WordsUtil.getWords(question.getBody().toLowerCase()).stream()
                .filter(s -> getAnswers().contains(s))
                .count();
    }

    abstract String getAnswers();
}
