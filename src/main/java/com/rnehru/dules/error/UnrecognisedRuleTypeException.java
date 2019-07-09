package com.rnehru.dules.error;

public class UnrecognisedRuleTypeException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Could not identify if a page or question rule type";
    }
}
