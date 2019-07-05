package com.rnehru.dules.model.logicalrule;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.model.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OrTest {

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
        assertTrue(new Or(trueRules).evaluate(context));
    }


    @Test
    public void evaluate_returnsFalse_whenAllRulesEvaluateToFalse() {
        List<Rule> falseRules = new ArrayList<>();
        falseRules.add(new FalseRule());
        falseRules.add(new FalseRule());

        assertEquals(2, falseRules.size());
        assertFalse(new Or(falseRules).evaluate(context));
    }

    @Test
    public void evaluate_returnsTrue_whenSomeRulesEvaluateToTrue() {
        List<Rule> mixedRules = new ArrayList<>();
        mixedRules.add(new FalseRule());
        mixedRules.add(new TrueRule());

        assertEquals(2, mixedRules.size());
        assertTrue(new Or(mixedRules).evaluate(context));
    }

}