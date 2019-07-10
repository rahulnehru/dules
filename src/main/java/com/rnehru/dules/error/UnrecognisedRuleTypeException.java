package com.rnehru.dules.error;

import com.google.common.annotations.VisibleForTesting;

public class UnrecognisedRuleTypeException extends RuntimeException {

    @VisibleForTesting
    static final String ERROR_MSG = "Could not identify if a page or question rule type";

    public UnrecognisedRuleTypeException() {}

    @Override
    public String getMessage() {
        return ERROR_MSG;
    }
}
