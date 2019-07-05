package com.rnehru.dules.model.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AnswerMatchesTest {

    @Test
    public void evaluate_returnsTrue_ifContextHasPageWithQuestionWithAnswerAsMatch() {
        Map<String, String> qa = new HashMap<>();
        qa.put("question", "answer");
        Page page = new Page("page", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertTrue(new AnswerMatches("page", "answer", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithQuestionWithAnswerThatDoesNotMatch() {
        Map<String, String> qa = new HashMap<>();
        qa.put("question", "notanswer");
        Page page = new Page("page", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertFalse(new AnswerMatches("page", "answer", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithQuestionThatDoesNotExist() {
        Map<String, String> qa = new HashMap<>();
        qa.put("notquestion", "answer");
        Page page = new Page("page", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertFalse(new AnswerMatches("page", "answer", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextWithPageThatDoesNotExist() {
        Map<String, String> qa = new HashMap<>();
        qa.put("question", "answer");
        Page page = new Page("notpage", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertFalse(new AnswerMatches("page", "answer", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasEmptyListOfPages() {
        List<Page> pages = new ArrayList<>();
        Context ctx = new Context(pages);

        assertFalse(new AnswerMatches("page", "answer", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPagesWithNoAnswers() {
        Map<String, String> qa = new HashMap<>();
        Page page = new Page("page", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertFalse(new AnswerMatches("page", "answer", "question").evaluate(ctx));
    }

}