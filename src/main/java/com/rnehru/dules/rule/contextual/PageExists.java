package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;

import java.util.Objects;

import static com.rnehru.dules.rule.Rule.contextInvalid;

public class PageExists extends DependsOnPageItem {


    public PageExists(String parentPage) {
        this.parentPage = parentPage;
    }

    @Override
    public boolean evaluate(Context context) {
        boolean isTrue = false;
        if(!contextInvalid(context)){
            for (Page page : context.getPages()) {
                if(Objects.equals(parentPage, page.getName()) &&
                        null != page.getQuestionsAndAnswers() &&
                        !page.getQuestionsAndAnswers().isEmpty()){
                    isTrue = true;
                }
            }
        }
        return isTrue;
    }
}
