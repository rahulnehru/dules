package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.rule.Rule;

import static com.rnehru.dules.rule.Rule.contextInvalid;


public final class AllPagesComplete implements Rule {

    public AllPagesComplete() {}

    @Override
    public boolean evaluate(Context context) {
        return !contextInvalid(context) && context.getPages().stream().allMatch(Page::isComplete);
    }

    @Override
    public boolean equals(Object obj) {
        return null!=obj && obj.getClass().equals(AllPagesComplete.class);
    }

    @Override
    public int hashCode() { return super.hashCode(); }
}
