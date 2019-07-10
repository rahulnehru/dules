package com.rnehru.dules.error;

public class UnrecognisedRuleTypeException extends RuntimeException {

    public UnrecognisedRuleTypeException() {}

    static final String ERROR_MSG = "Could not identify if a page or question rule type";

    @Override
    public String getMessage() {
        return ERROR_MSG;
    }
}
