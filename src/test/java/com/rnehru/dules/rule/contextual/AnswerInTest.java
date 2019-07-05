package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnswerInTest {

    List<String> options = new ArrayList<>();
    {
        options.add("opt1");
        options.add("opt2");
        options.add("opt3");
    }


  @Test
  public void evaluate_returnsFalse_whenContextNull() {
      assertFalse(new AnswerIn("page", "question", options).evaluate(null));
  }

    @Test
    public void evaluate_returnsFalse_whenContextHasNullPageList() {
        Context ctx = new Context(null);

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasEmptyPageList() {
        List<Page> pages = new ArrayList<>();
        Context ctx = new Context(pages);

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageListWithPagesButNotRelevantQuestion() {
        List<Page> pages = new ArrayList<>();
        pages.add(new Page("page", new HashMap<>()));
        Context ctx = new Context(pages);

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageListWithPagesWithQuestionButNullAnswer() {
        Map<String, String> qa = new HashMap<>();
        qa.put("question", null);
        List<Page> pages = new ArrayList<>();
        pages.add(new Page("page", qa));
        Context ctx = new Context(pages);

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageListWithPagesWithQuestionButEmptyAnswer() {
        Map<String, String> qa = new HashMap<>();
        qa.put("question", "");
        List<Page> pages = new ArrayList<>();
        pages.add(new Page("page", qa));
        Context ctx = new Context(pages);

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageListWithPagesWithQuestionButWrongAnswer() {
        Map<String, String> qa = new HashMap<>();
        qa.put("question", "wronganswer");
        List<Page> pages = new ArrayList<>();
        pages.add(new Page("page", qa));
        Context ctx = new Context(pages);

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasPageListWithPagesWithQuestionButAnswerInOptions() {
        Map<String, String> qa = new HashMap<>();
        qa.put("question", "opt1");
        List<Page> pages = new ArrayList<>();
        pages.add(new Page("page", qa));
        Context ctx = new Context(pages);

        assertTrue(new AnswerIn("page", "question", options).evaluate(ctx));
    }


}