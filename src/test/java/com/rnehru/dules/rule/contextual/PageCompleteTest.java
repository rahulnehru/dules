package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.utils.ContextBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        Context ctx = new ContextBuilder().build();

        assertFalse(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPagesWithNullQA() {
        Context ctx = new ContextBuilder().withPageAnswer("page", null).build();

        assertFalse(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPagesWithEmptyQA() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{}).build();

        assertFalse(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPagesWithQAWithIncompleteQuestion() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"q", null}}).build();

        assertFalse(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasPagesWithQAWithCompleteEmptyQuestion() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"q", "a"}}).build();

        assertTrue(new PageComplete("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasPagesWithQAWithCompleteQuestion() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"q", "foobar"}}).build();

        assertTrue(new PageComplete("page").evaluate(ctx));
    }

}