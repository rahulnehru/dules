package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public final class PageComplete extends ContextDrivenRule {

    public PageComplete(String parentPage) {
        this.parentPage = parentPage;
    }

    @Override
    public final boolean evaluate(Context context) {
        boolean isTrue = false;
        if(!contextInvalid(context)) {
            for(Page p: context.getPages()) {
                if(null != p.getName() && this.parentPage.equals(p.getName())) {
                    isTrue = p.isComplete();
                }
            }
        }
        return isTrue;
    }

    @Override
    public boolean equals(Object obj) {
        return null != obj &&
                obj.getClass().equals(PageComplete.class) &&
                ((PageComplete) obj).parentPage.equals(this.parentPage);
    }
}
