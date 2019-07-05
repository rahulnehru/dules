package com.rnehru.dules.rule.logical;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AndTest {

    private Context context = new Context(new ArrayList<>());

    class TrueRule implements Rule {
        @Override
        public boolean evaluate(Context context) {
            return true;
        }
    }

    class FalseRule implements Rule {
        @Override
        public boolean evaluate(Context context) {
            return false;
        }
    }


    @Test
    public void evaluate_returnsTrue_whenAllRulesEvaluateToTrue() {
        List<Rule> trueRules = new ArrayList<>();
        trueRules.add(new TrueRule());
        trueRules.add(new TrueRule());

        assertEquals(2, trueRules.size());
        assertTrue(new And(trueRules).evaluate(context));
    }


    @Test
    public void evaluate_returnsFalse_whenAllRulesEvaluateToFalse() {
        List<Rule> falseRules = new ArrayList<>();
        falseRules.add(new FalseRule());
        falseRules.add(new FalseRule());

        assertEquals(2, falseRules.size());
        assertFalse(new And(falseRules).evaluate(context));
    }

    @Test
    public void evaluate_returnsFalse_whenSomeRulesEvaluateToFalse() {
        List<Rule> mixedRules = new ArrayList<>();
        mixedRules.add(new FalseRule());
        mixedRules.add(new TrueRule());

        assertEquals(2, mixedRules.size());
        assertFalse(new And(mixedRules).evaluate(context));
    }

}