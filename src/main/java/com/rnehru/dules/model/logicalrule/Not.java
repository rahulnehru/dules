package com.rnehru.dules.model.logicalrule;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.model.Rule;

import java.util.ArrayList;
import java.util.List;

public class Not extends LogicalRule {

    public Not(Rule rule) {
        List<Rule> rules =  new ArrayList<>();
        rules.add(rule);
        this.rules = rules;
    }

    @Override
    public boolean evaluate(Context context) {
        if(null != rules && rules.size()==1 && null != rules.get(0)) {
            return !rules.get(0).evaluate(context);
        }
        return false;
    }
}
