package com.rnehru.dules.higher;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;

/**
 * QuestionRule is a container for the rules associated to make a question appear.
 */

public class QuestionRule implements Rule {

    private String childQuestion;
    private Rule rule;

    public QuestionRule(String childQuestion, Rule rule) {
        this.childQuestion = childQuestion;
        this.rule = rule;
    }

    @Override
    public boolean evaluate(Context context) {
        return rule.evaluate(context);
    }
}
