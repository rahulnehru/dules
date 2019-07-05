package com.rnehru.dules.model.logicalrule;

import com.rnehru.dules.model.Rule;

import java.util.List;

public class Or extends LogicalRule {

    public Or(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public boolean evaluate(String context) {
        int trueRules = 0;
        for (Rule rule : rules) {
            if(rule.evaluate(context)) {
                trueRules++;
            }
        }
        return trueRules > 0;
    }
}
