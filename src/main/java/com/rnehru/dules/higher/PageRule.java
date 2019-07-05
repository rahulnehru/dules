package com.rnehru.dules.higher;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;

/**
 * PageRule is a container for the rules associated to make a page appear.
 */

class PageRule implements Rule {

    private String childPage;
    private Rule rule;

    public PageRule(String childPage, Rule rule) {
        this.childPage = childPage;
        this.rule = rule;
    }

    @Override
    public boolean evaluate(Context context) {
        return rule.evaluate(context);
    }
}
