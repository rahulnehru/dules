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

public class AnswerInTest {

    private final String options = "$REF";

  @Test
  public void evaluate_returnsFalse_whenContextNull() {
      assertFalse(new AnswerIn("page", "question", options).evaluate(null));
  }

    @Test
    public void evaluate_returnsFalse_whenContextHasNullPageList() {
        Context ctx = new Context(null);

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasEmptyPageList() {
        Context ctx = new ContextBuilder().build();

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageListWithPagesButNotRelevantQuestion() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{}).build();

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageListWithPagesWithQuestionButNullAnswer() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", null}}).build();

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageListWithPagesWithQuestionButEmptyAnswer() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", ""}}).build();

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasPageListWithPagesWithQuestionButWrongAnswer() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", "wronganswer"}}).build();

        assertFalse(new AnswerIn("page", "question", options).evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasPageListWithPagesWithQuestionButAnswerInOptions() {
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"question", "REF"}}).build();

        assertTrue(new AnswerIn("page", "question", options).evaluate(ctx));
    }


}