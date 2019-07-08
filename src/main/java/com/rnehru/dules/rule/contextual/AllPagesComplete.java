package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.rule.Rule;

import static com.rnehru.dules.rule.Rule.contextInvalid;


public class AllPagesComplete implements Rule {

    @Override
    public boolean evaluate(Context context) {
        boolean isTrue = true;
        if(!contextInvalid(context)) {
            for (Page p : context.getPages()) {
                if(!p.isComplete()) {
                    isTrue = false;
                }
            }
        } else {
            isTrue = false;
        }
        return isTrue;
    }
}
