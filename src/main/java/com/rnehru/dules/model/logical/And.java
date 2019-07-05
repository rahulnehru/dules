package com.rnehru.dules.model.logical;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.model.Rule;

import java.util.List;

public class And extends LogicalRule {

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
}
