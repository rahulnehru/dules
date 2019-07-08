package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.rule.Rule;

import java.time.LocalDate;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public class AnswerDateAfter extends DependsOnPageItem {

    private LocalDate comparisonDate;
    private String question;

    public AnswerDateAfter(String parentPage, String question, String comparisonDate) {
        this.parentPage = parentPage;
        this.question = question;
        this.comparisonDate = LocalDate.parse(comparisonDate);
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
                    isTrue = LocalDate.parse(page.getQuestionsAndAnswers().get(question)).isAfter(comparisonDate);
                }
            }
        }
        return isTrue;
    }
}
