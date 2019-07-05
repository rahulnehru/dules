package com.rnehru.dules.model.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.model.Rule;

public class AllPagesComplete implements Rule {

    @Override
    public boolean evaluate(Context context) {
        boolean isTrue = true;
        if(null != context && null != context.getPages() && !context.getPages().isEmpty()) {
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
