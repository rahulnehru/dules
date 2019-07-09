package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public final class AnswerMatches extends ContextDrivenRule {

    private final String answer;
    private final String question;

    public AnswerMatches(String parentPage, String answer, String question) {
        this.parentPage = parentPage;
        this.answer = answer;
        this.question = question;
    }

    @Override
    public final boolean evaluate(Context context) {
        return !contextInvalid(context) && context.getPages().stream().anyMatch(page ->
                page.getName().equals(parentPage) &&
                        null != page.getQuestionsAndAnswers() &&
                        null != page.getQuestionsAndAnswers().get(question) &&
                        page.getQuestionsAndAnswers().get(question).equals(answer)
        );
    }
}
