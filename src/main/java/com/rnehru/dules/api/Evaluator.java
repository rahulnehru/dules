package com.rnehru.dules.api;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.rule.Rule;
import org.jetbrains.annotations.NotNull;

public interface Evaluator {

    boolean evaluate(@NotNull Context context, @NotNull Rule rule);
    boolean evaluate(@NotNull Context context, @NotNull String dslRule);

}
