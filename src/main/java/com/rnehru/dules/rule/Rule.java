package com.rnehru.dules.rule;

import com.rnehru.dules.context.Context;

public interface Rule {

    boolean evaluate(Context context);

    static boolean contextInvalid(Context ctx) {
        return (null == ctx || null == ctx.getPages() || ctx.getPages().isEmpty());
    }

}
