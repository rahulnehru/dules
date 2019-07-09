package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public final class PageExists extends ContextDrivenRule {

    public PageExists(String parentPage) {
        this.parentPage = parentPage;
    }

    @Override
    public final boolean evaluate(Context context) {
        return !contextInvalid(context) && context.getPages().stream().anyMatch(page ->
                page.getName().equals(parentPage) &&
                        null != page.getQuestionsAndAnswers() &&
                        !page.getQuestionsAndAnswers().isEmpty()
        );
    }
}
