package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.rule.Rule;

import static com.rnehru.dules.rule.Rule.contextInvalid;


public final class AllPagesComplete extends StateDrivenRule {

    @Override
    public final boolean evaluate(Context context) {
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

    @Override
    public boolean equals(Object obj) {
        return null!=obj && obj.getClass().equals(AllPagesComplete.class);
    }
}
