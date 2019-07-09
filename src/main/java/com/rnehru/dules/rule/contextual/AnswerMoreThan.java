package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public class AnswerMoreThan extends DependsOnPageItem {

    private final int comparisonValue;
    private final String question;

    public AnswerMoreThan(String parentPage, String question, int comparisonValue) {
        this.parentPage = parentPage;
        this.question = question;
        this.comparisonValue = comparisonValue;
    }

    @Override
    public boolean evaluate(Context context) {
        boolean isTrue = false;
        if(!contextInvalid(context)){
            for(Page page: context.getPages()) {
                if(page.getName().equals(parentPage) &&
                        null != page.getQuestionsAndAnswers() &&
                        page.getQuestionsAndAnswers().containsKey(question) &&
                        null != page.getQuestionsAndAnswers().get(question)) {
                    isTrue = Integer.parseInt(page.getQuestionsAndAnswers().get(question)) > comparisonValue ;
                }
            }
        }
        return isTrue;
    }
}
