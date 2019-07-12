package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.utils.ContextBuilder;
import org.junit.Test;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AnswerDateBeforeTest {

    @Test(expected = DateTimeParseException.class)
    public void constructor_throwsException_whenComparisonDateNotInDateFormat() {
        new AnswerDateBefore("parentPage", "question",  "bla");
    }

    @Test
    public void evaluate_returnsFalse_whenContextIsNull() {
        assertFalse(new AnswerDateBefore("page", "question", "2010-01-01").evaluate(null));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasNullPages() {
        Context ctx = new Context(null);
        assertFalse(new AnswerDateBefore("page", "question", "2010-01-01").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasEmptyPages() {
        Context ctx = new ContextBuilder().build();
        assertFalse(new AnswerDateBefore("page", "question", "2010-01-01").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageButHasNullMap() {
        Context ctx = new ContextBuilder().withPageAnswer("page", null).build();
        assertFalse(new AnswerDateBefore("page", "question", "2010-01-01").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageButHasEmptyMap() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{}).build();
        assertFalse(new AnswerDateBefore("page", "question", "2010-01-01").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageButHasMapWithNullAnswers() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", null}}).build();
        assertFalse(new AnswerDateBefore("page", "question", "2010-01-01").evaluate(ctx));
    }

    @Test(expected = DateTimeParseException.class)
    public void evaluate_throwsException_whenContextHasAnswerForQuestionWhichIsIncorrectFormat() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", "bla"}}).build();
        new AnswerDateBefore("page", "question", "2010-01-01").evaluate(ctx);
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasAnswerForQuestionWhichIsAfterComparisonDate() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", "2020-01-01"}}).build();
        assertFalse(new AnswerDateBefore("page", "question", "2010-01-01").evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasAnswerForQuestionWhichIsBeforeComparisonDate() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", "1970-01-01"}}).build();
        assertTrue(new AnswerDateBefore("page", "question", "2010-01-01").evaluate(ctx));
    }

}