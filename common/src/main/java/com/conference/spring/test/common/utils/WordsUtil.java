package com.conference.spring.test.common.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 25/03/2017.
 */
public class WordsUtil {
    private static ApplicationContext context = new AnnotationConfigApplicationContext("com.conference.spring.test.common");

    public static List<String> getWords(String text) {
        List<String> words = new ArrayList<>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex,lastIndex));
            }
        }

        return words;
    }

    public static boolean isGarbage(String word) {
        return context.getBean(GarbageBag.class).garbage.contains(word);
    }

    public static void main(String[] args) {
        System.out.println(isGarbage("tsdo"));
    }
}
