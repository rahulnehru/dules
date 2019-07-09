package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

import java.time.LocalDate;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public final class AnswerDateBefore extends ContextDrivenRule {

    private final LocalDate comparisonDate;
    private final String question;

    public AnswerDateBefore(String parentPage, String question, String comparisonDate) {
        this.parentPage = parentPage;
        this.question = question;
        this.comparisonDate = LocalDate.parse(comparisonDate);
    }

    @Override
    public final boolean evaluate(Context context) {
        boolean isTrue = false;
        if(!contextInvalid(context)){
            for(Page page: context.getPages()) {
                if(page.getName().equals(parentPage) &&
                        null != page.getQuestionsAndAnswers() &&
                        page.getQuestionsAndAnswers().containsKey(question) &&
                        null != page.getQuestionsAndAnswers().get(question)) {
                    isTrue = LocalDate.parse(page.getQuestionsAndAnswers().get(question)).isBefore(comparisonDate);
                }
            }
        }
        return isTrue;
    }

    @Override
    public boolean equals(Object obj) {
        return null!=obj &&
                obj.getClass().equals(AnswerDateBefore.class) &&
                ((AnswerDateBefore) obj).parentPage.equals(this.parentPage) &&
                ((AnswerDateBefore) obj).comparisonDate.equals(this.comparisonDate) &&
                ((AnswerDateBefore) obj).question.equals(this.question);
    }
}
