package com.conference.spring.test.controller;

import com.conference.spring.test.domain.Answer;
import com.conference.spring.test.domain.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author tolkv
 * @version 23/03/2017
 */
@Controller
public class AnswerController {
  private static Map<Question, Answer> answerList;

  @RequestMapping(value = "/answer", method = RequestMethod.POST)
  public String answer(@RequestBody Answer answer) {
//    answerList.put(answer);
//    modelMap.
    return "";
  }

  @RequestMapping(value = "/answer", method = RequestMethod.GET)
  public @ResponseBody String answerJson(Model model) {
//    answerList.put(answer);
//    modelMap.
    return "";
  }
}
