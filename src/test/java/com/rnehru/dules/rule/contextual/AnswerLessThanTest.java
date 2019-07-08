package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AnswerLessThanTest {

    @Test
    public void evaluate_returnsFalse_whenContextIsNull() {
        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(null));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasNullPages() {
        Context ctx = new Context(null);
        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasEmptyPages() {
        Context ctx = new Context(new ArrayList<>());
        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageButHasNullMap() {
        Page page = new Page("page", null);
        List<Page> pages = new ArrayList<>();
        pages.add(page);
        Context ctx = new Context(pages);
        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageButHasEmptyMap() {
        Map<String, String> answers = new HashMap<>();
        Page page = new Page("page", answers);
        List<Page> pages = new ArrayList<>();
        pages.add(page);
        Context ctx = new Context(pages);
        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageButHasMapWithNullAnswers() {
        Map<String, String> answers = new HashMap<>();
        answers.put("question", null);
        Page page = new Page("page", answers);
        List<Page> pages = new ArrayList<>();
        pages.add(page);
        Context ctx = new Context(pages);
        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageWithAnswerThatIsGreater() {
        Map<String, String> answers = new HashMap<>();
        answers.put("question", "2");
        Page page = new Page("page", answers);
        List<Page> pages = new ArrayList<>();
        pages.add(page);
        Context ctx = new Context(pages);
        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasPageWithAnswerThatIsLess() {
        Map<String, String> answers = new HashMap<>();
        answers.put("question", "2");
        Page page = new Page("page", answers);
        List<Page> pages = new ArrayList<>();
        pages.add(page);
        Context ctx = new Context(pages);
        assertTrue(new AnswerLessThan("page", "question", 3).evaluate(ctx));
    }

}