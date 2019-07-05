package com.rnehru.dules.model.pagerule;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

import java.util.List;
import java.util.Objects;

public class AnswerIn extends PageRule {

    private String question;
    private List<String> options;

    public AnswerIn(String parentPage, String question, List<String> options) {
        this.parentPage = parentPage;
        this.question = question;
        this.options = options;
    }

    @Override
    public boolean evaluate(Context context) {
        boolean isTrue = false;
        if(null != context && null != context.getPages() && !context.getPages().isEmpty()) {
            for(Page page: context.getPages()){
                if(page.getName().equals(parentPage) &&
                        page.getQuestionsAndAnswers().containsKey(question) &&
                        options.contains(page.getQuestionsAndAnswers().get(question)) &&
                        !page.getQuestionsAndAnswers().get(question).isEmpty() &&
                        null != page.getQuestionsAndAnswers().get(question)) {
                    isTrue = true;
                }
            }
        }
        return isTrue;
    }
}
