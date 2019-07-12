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

public class AnswerMatchesTest {

    @Test
    public void evaluate_returnsTrue_ifContextHasPageWithQuestionWithAnswerAsMatch() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", "answer"}}).build();

        assertTrue(new AnswerMatches("page", "question", "answer").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithQuestionWithAnswerThatDoesNotMatch() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", "notanswer"}}).build();

        assertFalse(new AnswerMatches("page", "question", "answer").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPageWithQuestionThatDoesNotExist() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"notquestion", "answer"}}).build();

        assertFalse(new AnswerMatches("page", "question", "answer").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextWithPageThatDoesNotExist() {
        Context ctx = new ContextBuilder().withPageAnswer("notpage", new String[][]{{"notquestion", "answer"}}).build();

        assertFalse(new AnswerMatches("page", "question", "answers").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasEmptyListOfPages() {
        Context ctx = new ContextBuilder().build();

        assertFalse(new AnswerMatches("page", "question", "answers").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_ifContextHasPagesWithNoAnswers() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{}).build();

        assertFalse(new AnswerMatches("page", "question", "answer").evaluate(ctx));
    }

}