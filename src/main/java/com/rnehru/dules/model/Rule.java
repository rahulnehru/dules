package com.rnehru.dules.model;

import com.rnehru.dules.context.Context;

public interface Rule {

    boolean evaluate(Context context);

}
