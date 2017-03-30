package com.conference.spring.test.webassistant.service.resolvers.words;

import com.conference.spring.test.common.utils.WordsComposer;
import com.conference.spring.test.webassistant.domain.Question;
import lombok.RequiredArgsConstructor;

/**
 * @author Evegeny
 * @version 28/03/2017
 */
@RequiredArgsConstructor
public abstract class AbstractWordsFrequencyResolver implements WordsFrequencyResolver {
    private final WordsComposer wordsComposer;

    @Override
    public int match(Question question) {
        return (int) wordsComposer.extractWordsWithoutGarbage(question.getBody()).stream()
                .filter(s -> getAnswers().contains(s))
                .count();
    }

    protected abstract String getAnswers();
}
