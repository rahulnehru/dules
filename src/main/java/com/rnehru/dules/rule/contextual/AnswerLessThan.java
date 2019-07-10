package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public final class AnswerLessThan extends ContextDrivenRule {

    private final int comparisonValue;
    private final String question;

    public AnswerLessThan(String parentPage, String question, int comparisonValue) {
        this.parentPage = parentPage;
        this.question = question;
        this.comparisonValue = comparisonValue;
    }

    @Override
    public boolean evaluate(Context context) {
        return !contextInvalid(context) && context.getPages().stream().anyMatch(page ->
                page.getName().equals(parentPage) &&
                        null != page.getQuestionsAndAnswers() &&
                        null != page.getQuestionsAndAnswers().get(question) &&
                        Integer.parseInt(page.getQuestionsAndAnswers().get(question)) < comparisonValue
        );
    }

    @Override
    public boolean equals(Object obj) {
        return null != obj &&
                obj.getClass().equals(AnswerLessThan.class) &&
                ((AnswerLessThan) obj).parentPage.equals(parentPage) &&
                ((AnswerLessThan) obj).question.equals(question) &&
                ((AnswerLessThan) obj).comparisonValue == comparisonValue;
    }
}
