package com.rnehru.dules.rule.logical;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NotTest {

    private final Context context = new Context(new ArrayList<>());

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
    public void evaluate_returnsFalse_internalRuleEvaluatesToTrue() {
        assertFalse(new Not(new TrueRule()).evaluate(context));
    }

    @Test
    public void evaluate_returnsTrue_internalRuleEvaluatesToFalse() {
        assertTrue(new Not(new FalseRule()).evaluate(context));
    }

    @Test
    public void evaluate_returnsFalse_whenNotRuleIsNull() {
        assertFalse(new Not(null).evaluate(context));
    }

}