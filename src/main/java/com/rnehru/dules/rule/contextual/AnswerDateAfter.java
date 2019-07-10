package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;

import java.time.LocalDate;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public final class AnswerDateAfter extends ContextDrivenRule {

    private final LocalDate comparisonDate;
    private final String question;

    public AnswerDateAfter(String parentPage, String question, String comparisonDate) {
        this.parentPage = parentPage;
        this.question = question;
        this.comparisonDate = LocalDate.parse(comparisonDate);
    }

    @Override
    public boolean evaluate(Context context) {
        return !contextInvalid(context) && context.getPages().stream().anyMatch(page ->
                page.getName().equals(parentPage) &&
                        null != page.getQuestionsAndAnswers() &&
                        null != page.getQuestionsAndAnswers().get(question) &&
                        LocalDate.parse(page.getQuestionsAndAnswers().get(question)).isAfter(comparisonDate)
                );
    }

    @Override
    public boolean equals(Object obj) {
        return null != obj &&
                obj.getClass().equals(AnswerDateAfter.class) &&
                ((AnswerDateAfter) obj).parentPage.equals(this.parentPage) &&
                ((AnswerDateAfter) obj).comparisonDate.equals(this.comparisonDate) &&
                ((AnswerDateAfter) obj).question.equals(this.question);
    }

    @Override
    public int hashCode() { return super.hashCode(); }
}
