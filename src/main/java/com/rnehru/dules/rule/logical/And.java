package com.rnehru.dules.rule.logical;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;

import java.util.List;

public final class And extends LogicalRule {

    public And(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public boolean evaluate(Context context) {
        int trueRules = 0;
        for (Rule rule : rules) {
            if(rule.evaluate(context)) {
                trueRules++;
            }
        }
        return rules.size()==trueRules;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null &&
                obj.getClass().equals(And.class) &&
                ((And) obj).rules.equals(rules);
    }

    @Override
    public int hashCode() { return super.hashCode(); }
}
