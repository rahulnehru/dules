package com.rnehru.dules.error;

import org.junit.Test;

import static com.rnehru.dules.error.UnrecognisedRuleTypeException.errorMsg;
import static org.junit.Assert.assertEquals;

public class UnrecognisedRuleTypeExceptionTest {


    @Test
    public void getMessage_returnsOverrideMessage() {
        assertEquals(errorMsg, new UnrecognisedRuleTypeException().getMessage());
    }
}
