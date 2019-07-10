package com.rnehru.dules.api;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;
import org.jetbrains.annotations.NotNull;

public class DuleEvaluator implements Evaluator {

    public DuleEvaluator() {}

    DuleParser parser = new DuleParser();

    @Override
    public boolean evaluate(@NotNull Context context, @NotNull Rule rule){
        return rule.evaluate(context);
    }

    @Override
    public boolean evaluate(@NotNull Context context, @NotNull String dslRule){
        return parser.parseRule(dslRule).evaluate(context);
    }

}