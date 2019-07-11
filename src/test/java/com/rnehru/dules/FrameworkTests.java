package com.rnehru.dules;

import com.rnehru.dules.api.DuleParser;
import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.rule.Rule;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class FrameworkTests {

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


}


class ContextBuilder {

    private List<Page> pages = new ArrayList<>();

    protected ContextBuilder withPageAnswer(@NotNull String p, String[][] qa) {
        Map<String, String> answers = new HashMap<>();
        for (String[] aQa : qa) {
            String q = aQa[0];
            String a = aQa[1];
            answers.put(q, a);
        }
        pages.removeIf(page -> page.getName().equals(p));
        pages.add(new Page(p, answers));
        return this;
    }

    protected Context build() {
        return new Context(this.pages);
    }

}