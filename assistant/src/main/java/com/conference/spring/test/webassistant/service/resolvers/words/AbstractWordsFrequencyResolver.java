package com.conference.spring.test.webassistant.service.resolvers.words;

import com.conference.spring.test.webassistant.domain.Question;

import java.util.List;

/**
 * Created by Evegeny on 28/03/2017.
 */
public abstract class AbstractWordsFrequencyResolver implements WordsFrequencyResolver {
    @Override
    public int match(Question question) {
        return (int) getWords(question.getBody()).stream()
                .filter(s -> getAnswers().contains(s))
                .count();
    }

    protected abstract String getAnswers();
    protected abstract List<String> getWords(String text);
}
