package com.rnehru.dules.error;

import org.junit.Test;

import static com.rnehru.dules.error.UnrecognisedRuleTypeException.ERROR_MSG;
import static org.junit.Assert.assertEquals;

public class UnrecognisedRuleTypeExceptionTest {


    @Test
    public void getMessage_returnsOverrideMessage() {
        assertEquals(ERROR_MSG, new UnrecognisedRuleTypeException().getMessage());
    }
}
