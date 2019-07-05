package com.rnehru.dules.model.pagerule;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PageExistsTest {

    @Test
    public void evaluate_returnsTrue_ifContextHasPageWithAnswers() {
        Map<String, String> qa = new HashMap<>();
        qa.put("q", "a");
        Page page = new Page("page", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertTrue(new PageExists("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithNoAnswers() {
        Map<String, String> qa = new HashMap<>();
        Page page = new Page("page", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertFalse(new PageExists("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithNullQA() {
        Page page = new Page("page", null);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertFalse(new PageExists("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextDoesNotHavePage() {
        Map<String, String> qa = new HashMap<>();
        qa.put("q", "a");
        Page page = new Page("notpage", qa);
        List<Page> pages = new ArrayList<>(); pages.add(page);
        Context ctx = new Context(pages);

        assertFalse(new PageExists("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifPagesAreEmpty() {
        List<Page> pages = new ArrayList<>();
        Context ctx = new Context(pages);

        assertFalse(new PageExists("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifPagesAreNull() {
        Context ctx = new Context(null);

        assertFalse(new PageExists("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextIsNull() {
        assertFalse(new PageExists("page").evaluate(null));
    }
}