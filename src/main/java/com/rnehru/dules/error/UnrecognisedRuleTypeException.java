package com.rnehru.dules.error;

public class UnrecognisedRuleTypeException extends RuntimeException {

    static final String ERROR_MSG = "Could not identify if a page or question rule type";

    public UnrecognisedRuleTypeException() {}

    @Override
    public String getMessage() {
        return ERROR_MSG;
    }
}
