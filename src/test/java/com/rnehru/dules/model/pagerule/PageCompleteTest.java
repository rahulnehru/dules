package com.rnehru.dules.model.pagerule;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PageCompleteTest {

    @Test
    public void evaluate_returnsFalse_whenContextIsNull() {
        assertFalse(new PageComplete("page").evaluate(null));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasNullPages() {
        Context ctx = new Context(null);

        assertFalse(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasEmptyPages() {
        List<Page> pages = new ArrayList<>();
        Context ctx = new Context(pages);

        assertFalse(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPagesWithNullQA() {
        List<Page> pages = new ArrayList<>();
        Page p = new Page("page", null);
        pages.add(p);
        Context ctx = new Context(pages);

        assertFalse(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPagesWithEmptyQA() {
        Map<String, String> qa = new HashMap<>();
        List<Page> pages = new ArrayList<>();
        Page p = new Page("page", qa);
        pages.add(p);
        Context ctx = new Context(pages);

        assertFalse(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPagesWithQAWithIncompleteQuestion() {
        Map<String, String> qa = new HashMap<>();
        qa.put("q", null);
        List<Page> pages = new ArrayList<>();
        Page p = new Page("page", qa);
        pages.add(p);
        Context ctx = new Context(pages);

        assertFalse(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasPagesWithQAWithCompleteEmptyQuestion() {
        Map<String, String> qa = new HashMap<>();
        qa.put("q", "");
        List<Page> pages = new ArrayList<>();
        Page p = new Page("page", qa);
        pages.add(p);
        Context ctx = new Context(pages);

        assertTrue(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasPagesWithQAWithCompleteQuestion() {
        Map<String, String> qa = new HashMap<>();
        qa.put("q", "foobar");
        List<Page> pages = new ArrayList<>();
        Page p = new Page("page", qa);
        pages.add(p);
        Context ctx = new Context(pages);

        assertTrue(new PageComplete("page").evaluate(ctx));
    }

}