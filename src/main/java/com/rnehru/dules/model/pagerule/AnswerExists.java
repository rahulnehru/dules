package com.rnehru.dules.model.pagerule;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

import java.util.List;
import java.util.Objects;

public class AnswerExists extends PageRule {

    private String question;

    public AnswerExists(String parentPage, String question) {
        this.parentPage = parentPage;
        this.question = question;
    }

    @Override
    public boolean evaluate(Context context) {
        boolean isTrue = false;
        if (null != context.getPages()) {
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
            return isTrue;
        } else {
            return isTrue;
        }
    }
}
