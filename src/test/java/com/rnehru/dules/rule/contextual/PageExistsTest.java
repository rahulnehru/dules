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

public class PageExistsTest {

    @Test
    public void evaluate_returnsTrue_ifContextHasPageWithAnswers() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"q", "foobar"}}).build();

        assertTrue(new PageExists("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithNoAnswers() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{}).build();

        assertFalse(new PageExists("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithNullQA() {
        Context ctx = new ContextBuilder().withPageAnswer("page", null).build();

        assertFalse(new PageExists("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextDoesNotHavePage() {
        Context ctx = new ContextBuilder().withPageAnswer("notpage", new String[][]{{"q", "foobar"}}).build();

        assertFalse(new PageExists("page").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifPagesAreEmpty() {
        Context ctx = new ContextBuilder().build();

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