package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public final class PageComplete extends ContextDrivenRule {

    public PageComplete(String parentPage) {
        this.parentPage = parentPage;
    }

    @Override
    public final boolean evaluate(Context context) {
        return !contextInvalid(context) && context.getPages().stream().anyMatch(page ->
                page.getName().equals(parentPage) && page.isComplete()
        );
    }

    @Override
    public boolean equals(Object obj) {
        return null != obj &&
                obj.getClass().equals(PageComplete.class) &&
                ((PageComplete) obj).parentPage.equals(this.parentPage);
    }
}
