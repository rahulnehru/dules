package com.rnehru.dules.api;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.model.Rule;

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
