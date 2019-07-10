package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;

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
    public boolean evaluate(Context context) {
        return !contextInvalid(context) && context.getPages().stream().anyMatch(page ->
                page.getName().equals(parentPage) &&
                        null != page.getQuestionsAndAnswers().get(question) &&
                        !page.getQuestionsAndAnswers().get(question).isEmpty() &&
                        options.contains(page.getQuestionsAndAnswers().get(question))
        );
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
