package com.rnehru.dules.model.questionrule;

import com.rnehru.dules.model.Rule;

abstract class QuestionRule implements Rule {

    protected String childQuestion;
    protected String parentPage;
    protected String parentQuestion;
    protected String parentAnswer;

}
