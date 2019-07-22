package com.rnehru.dules.error;

import com.google.common.annotations.VisibleForTesting;

public class InvalidRuleFileException extends Exception {

    @VisibleForTesting
    static final String ERROR_MSG = "File is not in valid format";

    public InvalidRuleFileException() { }

    @Override
    public String getMessage() {
        return ERROR_MSG;
    }
}
