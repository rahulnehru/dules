package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public final class AnswerIn extends ContextDrivenRule {

    private final String question;
    private final String options;

    public AnswerIn(String parentPage, String question, String options) {
        this.parentPage = parentPage;
        this.question = question;
        this.options = options;
    }

    @Override
    public final boolean evaluate(Context context) {
        boolean isTrue = false;
        if (!contextInvalid(context)) {
            for (Page page : context.getPages()) {
                if (page.getName().equals(parentPage) &&
                        page.getQuestionsAndAnswers().containsKey(question) &&
                        null != page.getQuestionsAndAnswers().get(question) &&
                        !page.getQuestionsAndAnswers().get(question).isEmpty()
                ) {
                    isTrue = options.contains(page.getQuestionsAndAnswers().get(question));
                }
            }
        }
        return isTrue;
    }

    @Override
    public boolean equals(Object obj) {
        return null != obj &&
                obj.getClass().equals(AnswerIn.class) &&
                ((AnswerIn) obj).parentPage.equals(parentPage) &&
                ((AnswerIn) obj).question.equals(question) &&
                ((AnswerIn) obj).options.equals(options);
    }
}
