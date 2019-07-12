package com.rnehru.dules;

import com.rnehru.dules.api.DuleParser;
import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;
import com.rnehru.dules.utils.ContextBuilder;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class FrameworkTest {

    private DuleParser parser = new DuleParser();

    @Test
    public void pageRule_allPagesComplete_returnsTrueWhenAllPagesComplete() {
        Rule r = parser.parseRule(".page(complete)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "a"}, {"t", "p"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void pageRule_allPagesComplete_returnsFalseWhenAllPagesNotComplete() {
        Rule r = parser.parseRule(".page(complete)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", null}, {"t", "p"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void questionRule_allPagesComplete_returnsTrueWhenAllPagesComplete() {
        Rule r = parser.parseRule(".question(complete)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "a"}, {"t", "p"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void questionRule_allPagesComplete_returnsFalseWhenAllPagesNotComplete() {
        Rule r = parser.parseRule(".question(complete)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", null}, {"t", "p"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void pageRule_pageComplete_returnsTrueWhenPageComplete() {
        Rule r = parser.parseRule(".page(complete__p)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "a"}, {"t", "p"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void pageRule_pageComplete_returnsFalseWhenPageNotComplete() {
        Rule r = parser.parseRule(".page(complete__p)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", null}, {"t", "p"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void questionRule_pageComplete_returnsTrueWhenPageComplete() {
        Rule r = parser.parseRule(".question(complete__p)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "a"}, {"t", "p"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void questionRule_pageComplete_returnsFalseWhenPageNotComplete() {
        Rule r = parser.parseRule(".question(complete__p)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", null}, {"t", "p"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void pageRule_pageExists_returnsTrueWhenPageExists() {
        Rule r = parser.parseRule(".page(p)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", null}, {"t", "p"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void pageRule_pageExists_returnsFalseWhenPageDoesNotExist() {
        Rule r = parser.parseRule(".page(q)");
        Context c = new ContextBuilder().build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void questionRule_pageExists_returnsTrueWhenPageExists() {
        Rule r = parser.parseRule(".question(p)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", null}, {"t", "p"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void questionRule_pageExists_returnsFalseWhenPageDoesNotExist() {
        Rule r = parser.parseRule(".question(q)");
        Context c = new ContextBuilder().build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void pageRule_answerExists_returnsTrueWhenQuestionHasBeenAnswered() {
        Rule r = parser.parseRule(".page(p__t)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", null}, {"t", "p"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void pageRule_answerExists_returnsFalseWhenQuestionHasNotBeenAnswered() {
        Rule r = parser.parseRule(".page(p__c)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", null}, {"t", "p"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void questionRule_answerExists_returnsTrueWhenQuestionHasBeenAnswered() {
        Rule r = parser.parseRule(".question(p__t)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", null}, {"t", "p"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void questionRule_answerExists_returnsFalseWhenQuestionHasNotBeenAnswered() {
        Rule r = parser.parseRule(".question(p__c)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", null}, {"t", "p"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void pageRule_answerIn_returnsTrueWhenAnswerBelongsInRef() {
        Rule r = parser.parseRule(".page(p__q__$abc");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "c"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void pageRule_answerIn_returnsFalseWhenAnswerIsNotInRef() {
        Rule r = parser.parseRule(".page(p__q__$abc");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "d"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void questionRule_answerIn_returnsTrueWhenAnswerBelongsInRef() {
        Rule r = parser.parseRule(".question(p__q__$abc");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "c"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void questionRule_answerIn_returnsFalseWhenAnswerIsNotInRef() {
        Rule r = parser.parseRule(".question(p__q__$abc");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "d"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void pageRule_answerLessThan_returnsTrueWhenAnswerIsLessThanValue() {
        Rule r = parser.parseRule(".page(p__q__<1)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "0"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void pageRule_answerLessThan_returnsFalseWhenAnswerIsNotLessThanValue() {
        Rule r = parser.parseRule(".page(p__q__<1)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "2"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void questionRule_answerLessThan_returnsTrueWhenAnswerIsLessThanValue() {
        Rule r = parser.parseRule(".question(p__q__<1)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "0"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void questionRule_answerLessThan_returnsFalseWhenAnswerIsNotLessThanValue() {
        Rule r = parser.parseRule(".question(p__q__<1))");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "2"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void pageRule_answerMoreThan_returnsTrueWhenAnswerIsMoreThanValue() {
        Rule r = parser.parseRule(".page(p__q__>1)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "2"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void pageRule_answerMoreThan_returnsFalseWhenAnswerIsNotMoreThanValue() {
        Rule r = parser.parseRule(".page(p__q__>1)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "0"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void questionRule_answerMoreThan_returnsTrueWhenAnswerIsMoreThanValue() {
        Rule r = parser.parseRule(".question(p__q__>1)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "2"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void questionRule_answerMoreThan_returnsFalseWhenAnswerIsNotMoreThanValue() {
        Rule r = parser.parseRule(".question(p__q__>1)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "0"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void pageRule_answerMatches_returnsTrueWhenAnswerMatches() {
        Rule r = parser.parseRule(".page(p__q__a)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "a"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void pageRule_answerMatches_returnsFalseWhenAnswerDoesNotMatch() {
        Rule r = parser.parseRule(".page(p__q__b)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "a"}}).build();
        assertFalse(r.evaluate(c));
    }

    @Test
    public void questionRule_answerMatches_returnsTrueWhenAnswerMatches() {
        Rule r = parser.parseRule(".question(p__q__a)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "a"}}).build();
        assertTrue(r.evaluate(c));
    }

    @Test
    public void questionRule_answerMatches_returnsFalseWhenAnswerDoesNotMatch() {
        Rule r = parser.parseRule(".question(p__q__b)");
        Context c = new ContextBuilder().withPageAnswer("p", new String[][]{{"q", "a"}}).build();
        assertFalse(r.evaluate(c));
    }


}


