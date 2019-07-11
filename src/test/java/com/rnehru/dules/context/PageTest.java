package com.rnehru.dules.context;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PageTest {

    @Test
    public void isComplete_returnsFalse_whenQaIsNull() {
        assertFalse(new Page("page", null).isComplete());
    }

    @Test
    public void isComplete_returnsFalse_whenQaIsEmpty() {
        Map<String, String> qa = new HashMap<>();

        assertFalse(new Page("page", qa).isComplete());
    }

    @Test
    public void isComplete_returnsFalse_whenQaHasQuestionsWithNullAnswers() {
        Map<String, String> qa = new HashMap<>();
        qa.put("q", null);

        assertFalse(new Page("page", qa).isComplete());
    }

    @Test
    public void isComplete_returnsTrue_whenQaHasQuestionsWithDefinedAnswers() {
        Map<String, String> qa = new HashMap<>();
        qa.put("q", "a");

        assertTrue(new Page("page", qa).isComplete());
    }

    @Test
    public void isComplete_returnsTrue_whenQaHasQuestionsWithEmptyAnswers() {
        Map<String, String> qa = new HashMap<>();
        qa.put("q", "");

        assertTrue(new Page("page", qa).isComplete());
    }
}
