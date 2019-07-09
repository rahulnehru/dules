package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

import java.util.Objects;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public class AnswerExists extends DependsOnPageItem {

    private final String question;

    public AnswerExists(String parentPage, String question) {
        this.parentPage = parentPage;
        this.question = question;
    }

    @Override
    public boolean evaluate(Context context) {
        boolean isTrue = false;
        if (!contextInvalid(context)) {
            for (Page page : context.getPages()) {
                if (null != page.getQuestionsAndAnswers() &&
                        Objects.equals(page.getName(), parentPage) &&
                        page.getQuestionsAndAnswers().containsKey(question) &&
                        null != page.getQuestionsAndAnswers().get(question) &&
                        !page.getQuestionsAndAnswers().get(question).isEmpty()
                ) {
                    isTrue = true;
                }
            }
        }
        return isTrue;
    }
}
