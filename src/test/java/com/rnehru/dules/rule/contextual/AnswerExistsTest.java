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

public class AnswerExistsTest {

    @Test
    public void evaluate_returnsTrue_ifContextHasPageWithQuestionAndAnswerNonEmpty() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", "answer"}}).build();

        assertTrue(new AnswerExists("page", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithQuestionExistsWithEmptyAnswer() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", ""}}).build();

        assertFalse(new AnswerExists("page", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithQuestionExistsWithNullAnswer() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", null}}).build();

        assertFalse(new AnswerExists("page", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithoutQuestion() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{}).build();

        assertFalse(new AnswerExists("page", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithoutPages() {
        Context ctx = new ContextBuilder().build();

        assertFalse(new AnswerExists("page", "question").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWitNullPages() {
        Context ctx = new Context(null);

        assertFalse(new AnswerExists("page", "question").evaluate(ctx));
    }

}