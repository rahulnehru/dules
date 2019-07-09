package com.rnehru.dules.api;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;
import org.jetbrains.annotations.NotNull;

public interface Evaluator {

    public boolean evaluate(@NotNull Context context, @NotNull Rule rule);
    public boolean evaluate(@NotNull Context context, @NotNull String dslRule);

}
