package com.conference.spring.test.common.utils;

import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author tolkv
 * @version 30/03/2017
 */
@RequiredArgsConstructor
public class AnswerComposer {
  private final WordsComposer wordsComposer;

  public String giveAnswerText(List<String> answers, String question) {
    Map<Integer, String> markVsAnswer = answers.stream().collect(Collectors.toMap(answer -> similarityMark(answer, question), Function.identity(),(s, s2) -> s));
    TreeMap<Integer, String> treeMap = new TreeMap<>(Comparator.reverseOrder());
    treeMap.putAll(markVsAnswer);
    return treeMap.firstEntry().getValue();
  }


  private int similarityMark(String answer, String question) {
    List<String> questionWords = wordsComposer.extractWordsWithoutGarbage(question);
    List<String> answerWords = wordsComposer.extractWordsWithoutGarbage(answer);
    int mark=0;
    for (String answerWord : answerWords) {
      for (String questionWord : questionWords) {

        if (answerWord.equalsIgnoreCase(questionWord)) {
          mark++;
        }
      }
    }
    return mark;
  }
}
