package com.rnehru.dules.model.pagerule;

import com.rnehru.dules.context.Context;

public class AnswerMatches extends PageRule {

    private String answer;
    private String question;

    public AnswerMatches(String childPage, String parentPage, String answer, String question) {
        this.childPage = childPage;
        this.parentPage = parentPage;
        this.answer = answer;
        this.question = question;
    }

    @Override
    public boolean evaluate(Context context) {
        return false;
    }
}
