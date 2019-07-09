package com.rnehru.dules.higher;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PageRuleTest {

    class AlwaysTrueRule implements Rule {

        @Override
        public boolean evaluate(Context context) {
            return true;
        }
    }

    class AlwaysFalseRule implements Rule {

        @Override
        public boolean evaluate(Context context) {
            return true;
        }
    }

    @Test
    public void evaluate_returnsTrue_whenUnderlyingRuleIsTrue() {
        assertTrue(new PageRule(new AlwaysTrueRule()).evaluate(new Context(null)));
    }

    @Test
    public void evaluate_returnsFalse_whenUnderlyingRuleIsFalse() {
        assertTrue(new PageRule(new AlwaysFalseRule()).evaluate(new Context(null)));
    }
}
