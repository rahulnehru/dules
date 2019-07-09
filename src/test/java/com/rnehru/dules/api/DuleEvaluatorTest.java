package com.rnehru.dules.api;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.parser.DSLParser;
import com.rnehru.dules.rule.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DuleEvaluatorTest {

    private class AlwaysFalseRule implements Rule {

        @Override
        public boolean evaluate(Context context) {
            return false;
        }
    }

    private class AlwaysTrueRule implements Rule {

        @Override
        public boolean evaluate(Context context) {
            return true;
        }
    }

    @Test
    public void evaluate_returnsFalse_whenRuleNotSatisfied() {
        assertFalse(new DuleEvaluator().evaluate(new Context(null), new AlwaysFalseRule()));
    }

    @Test
    public void evaluate_returnsTrue_whenRuleSatisfied() {
        assertTrue(new DuleEvaluator().evaluate(new Context(null), new AlwaysTrueRule()));
    }

    @Test
    public void evaluate_returnsFalse_whenDSLRuleNotSatisfied() {
        DuleParser parser = mock(DuleParser.class);
        when(parser.parseRule(anyString())).thenReturn(new AlwaysFalseRule());

        DuleEvaluator eval = new DuleEvaluator();
        eval.parser = parser;

        assertFalse(eval.evaluate(new Context(null), "some rule"));
    }

    @Test
    public void evaluate_returnsTrue_whenDSLRuleNotSatisfied() {
        DuleParser parser = mock(DuleParser.class);
        when(parser.parseRule(anyString())).thenReturn(new AlwaysTrueRule());

        DuleEvaluator eval = new DuleEvaluator();
        eval.parser = parser;

        assertTrue(eval.evaluate(new Context(null), "some rule"));
    }

}
