package com.rnehru.dules.rule.logical;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;

import java.util.ArrayList;
import java.util.List;

public final class Not extends LogicalRule {

    public Not(Rule rule) {
        List<Rule> rules =  new ArrayList<>();
        rules.add(rule);
        this.rules = rules;
    }

    @Override
    public final boolean evaluate(Context context) {
        if(null != rules && rules.size()==1 && null != rules.get(0)) {
            return !rules.get(0).evaluate(context);
        }
        return false;
    }
}
