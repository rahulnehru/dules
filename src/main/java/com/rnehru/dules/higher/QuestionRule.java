package com.rnehru.dules.higher;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;

/**
 * QuestionRule is a container for the rules associated to make a question appear.
 */

public class QuestionRule implements Rule {

    private final Rule rule;

    public QuestionRule(Rule rule) {
        this.rule = rule;
    }

    @Override
    public boolean evaluate(Context context) {
        return rule.evaluate(context);
    }
}
