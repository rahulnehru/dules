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

public class AnswerExistsTest {

    @Test
    public void evaluate_returnsTrue_ifContextHasPageWithQuestionAndAnswerNonEmpty() {
        Map<String, String> qa = new HashMap<>();
        qa.put("question", "answer");
        Page page = new Page("page", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertTrue(new AnswerExists("page", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithQuestionExistsWithEmptyAnswer() {
        Map<String, String> qa = new HashMap<>();
        qa.put("question", "");
        Page page = new Page("page", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertFalse(new AnswerExists("page", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithQuestionExistsWithNullAnswer() {
        Map<String, String> qa = new HashMap<>();
        qa.put("question", null);
        Page page = new Page("page", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertFalse(new AnswerExists("page", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithoutQuestion() {
        Map<String, String> qa = new HashMap<>();
        Page page = new Page("page", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertFalse(new AnswerExists("page", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithoutPages() {
        List<Page> pages = new ArrayList<>();
        Context ctx = new Context(pages);

        assertFalse(new AnswerExists("page", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWitNullPages() {
        Context ctx = new Context(null);

        assertFalse(new AnswerExists("page", "question").evaluate(ctx));
    }

}