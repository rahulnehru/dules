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
        Context ctx = new ContextBuilder().build();

        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageButHasNullMap() {
        Context ctx = new ContextBuilder().withPageAnswer("page", null).build();

        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageButHasEmptyMap() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{}).build();

        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageButHasMapWithNullAnswers() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", null}}).build();

        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageWithAnswerThatIsGreater() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", "2"}}).build();

        assertFalse(new AnswerLessThan("page", "question", 1).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasPageWithAnswerThatIsLess() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", "2"}}).build();

        assertTrue(new AnswerLessThan("page", "question", 3).evaluate(ctx));
    }

}