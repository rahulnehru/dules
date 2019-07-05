package com.rnehru.dules.model.pagerule;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

public class AllPagesComplete extends PageRule {

    public AllPagesComplete() {
        this.parentPage = null;
    }

    @Override
    public boolean evaluate(Context context) {
        boolean isTrue = true;
        if(null != context && null != context.getPages() && !context.getPages().isEmpty()) {
            for (Page p : context.getPages()) {
                if(!p.isComplete()) {
                    isTrue = false;
                }
            }
        }
        return isTrue;
    }
}
