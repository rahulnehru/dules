package com.rnehru.dules.rule.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import com.rnehru.dules.utils.ContextBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AllPagesCompleteTest {

    @Test
    public void evaluate_returnsFalse_whenContextIsNull(){
        assertFalse(new AllPagesComplete().evaluate(null));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasNullPages(){
        Context ctx = new Context(null);

        assertFalse(new AllPagesComplete().evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasEmptyPages(){
        Context ctx = new ContextBuilder().build();

        assertFalse(new AllPagesComplete().evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasIncompletePages(){
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"foo", null}}).build();

        assertFalse(new AllPagesComplete().evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasCompletePages(){
        Context ctx = new ContextBuilder().withPageAnswer("page", new String[][]{{"foo", "bar"}}).build();

        assertTrue(new AllPagesComplete().evaluate(ctx));
    }

}