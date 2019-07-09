package com.rnehru.dules.error;

public class UnrecognisedRuleTypeException extends RuntimeException {

    static final String errorMsg = "Could not identify if a page or question rule type";

    @Override
    public String getMessage() {
        return errorMsg;
    }
}
