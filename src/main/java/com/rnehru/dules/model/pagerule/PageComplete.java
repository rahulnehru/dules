package com.rnehru.dules.model.pagerule;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

public class PageComplete extends PageRule {

    public PageComplete(String parentPage) {
        this.parentPage = parentPage;
    }

    @Override
    public boolean evaluate(Context context) {
        boolean isTrue = false;
        if(null != context && null != context.getPages() && !context.getPages().isEmpty()) {
            for(Page p: context.getPages()) {
                if(null != p.getName() && this.parentPage.equals(p.getName())) {
                    isTrue = p.isComplete();
                }
            }
        }
        return isTrue;
    }
}
