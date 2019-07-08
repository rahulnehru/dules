package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.rule.Rule;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public class PageComplete extends DependsOnPageItem {

    public PageComplete(String parentPage) {
        this.parentPage = parentPage;
    }

    @Override
    public boolean evaluate(Context context) {
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
}
