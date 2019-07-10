package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public final class AnswerExists extends ContextDrivenRule {

    private final String question;

    public AnswerExists(String parentPage, String question) {
        this.parentPage = parentPage;
        this.question = question;
    }

    @Override
    public boolean evaluate(Context context) {
        return !contextInvalid(context) && context.getPages().stream().anyMatch(page ->
                page.getName().equals(parentPage) &&
                        null != page.getQuestionsAndAnswers() &&
                        null != page.getQuestionsAndAnswers().get(question) &&
                        !page.getQuestionsAndAnswers().get(question).isEmpty()
        );
    }

    @Override
    public boolean equals(Object obj) {
        return null != obj &&
                obj.getClass().equals(AnswerExists.class) &&
                ((AnswerExists) obj).parentPage.equals(this.parentPage) &&
                ((AnswerExists) obj).question.equals(this.question);
    }

    @Override
    public int hashCode() { return super.hashCode(); }
}
