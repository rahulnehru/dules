package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.rule.Rule;

import java.util.List;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public class AnswerIn extends DependsOnPageItem {

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
        if(!contextInvalid(context)) {
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
