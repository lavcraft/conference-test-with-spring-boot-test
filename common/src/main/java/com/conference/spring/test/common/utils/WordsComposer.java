package com.conference.spring.test.common.utils;

import com.conference.spring.test.common.GarbageProperties;
import lombok.RequiredArgsConstructor;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author tolkv
 * @version 30/03/2017
 */
@RequiredArgsConstructor
public class WordsComposer {
  private final GarbageProperties garbageProperties;

  public List<String> extractWordsWithoutGarbage(String text) {
    List<String> words = splitTextToWords(text);
    return refineText(words);
  }

  private List<String> refineText(List<String> words) {
    return words.stream()
        .filter(notGarbage())
        .collect(Collectors.toList());
  }

  private List<String> splitTextToWords(String text) {
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

  private Predicate<String> notGarbage() {
    return s -> !garbageProperties.getGarbage().contains(s.toLowerCase());
  }
}
