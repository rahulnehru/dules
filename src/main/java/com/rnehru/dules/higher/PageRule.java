package com.rnehru.dules.higher;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;

/**
 * PageRule is a container for the rules associated to make a page appear.
 */

public class PageRule implements Rule {

    private final Rule rule;

    public PageRule(Rule rule) {
        this.rule = rule;
    }

    @Override
    public boolean evaluate(Context context) {
        return rule.evaluate(context);
    }
}
