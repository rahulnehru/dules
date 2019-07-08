package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.rule.Rule;

import java.util.Objects;

import static com.rnehru.dules.rule.Rule.*;

public class AnswerExists extends DependsOnPageItem {

    private String question;

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
