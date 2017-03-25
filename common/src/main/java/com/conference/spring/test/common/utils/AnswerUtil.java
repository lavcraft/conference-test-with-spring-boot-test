package com.conference.spring.test.common.utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Evegeny on 25/03/2017.
 */
public class AnswerUtil {
    public static String giveAnswer(List<String> answers, String question) {
        Map<Integer, String> markVsAnswer = answers.stream().collect(Collectors.toMap(answer -> similarityMark(answer, question), Function.identity(),(s, s2) -> s));
        TreeMap<Integer, String> treeMap = new TreeMap<>(Comparator.reverseOrder());
        treeMap.putAll(markVsAnswer);
        return treeMap.firstEntry().getValue();


    }

    private static int similarityMark(String answer, String question) {

        List<String> questionWords = WordsUtil.getWords(question);
        List<String> answerWords = WordsUtil.getWords(answer);
        int mark=0;
        for (String answerWord : answerWords) {
            for (String questionWord : questionWords) {

                if (answerWord.equalsIgnoreCase(questionWord)) {
                    mark++;
                }
            }
        }
        return 0;
    }




    public static void main(String[] args) {
        List<String> answers = Arrays.asList("annotations sucks", "decorator is the best design pattern");
        System.out.println(giveAnswer(answers, "what do you think about annotations"));
    }
}
