package com.rnehru.dules.model.contextual;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

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
        List<Page> pages = new ArrayList<>();
        Context ctx = new Context(pages);

        assertFalse(new AllPagesComplete().evaluate(ctx));
    }

    @Test
    public void evaluate_returnsFalse_whenContextHasIncompletePages(){
        Map<String, String> qa = new HashMap<>();
        qa.put("foo", null);
        Page p = new Page("page", qa);
        List<Page> pages = new ArrayList<>();
        pages.add(p);
        Context ctx = new Context(pages);

        assertFalse(new AllPagesComplete().evaluate(ctx));
    }

    @Test
    public void evaluate_returnsTrue_whenContextHasCompletePages(){
        Map<String, String> qa = new HashMap<>();
        qa.put("foo", "bar");
        Page p = new Page("page", qa);
        List<Page> pages = new ArrayList<>();
        pages.add(p);
        Context ctx = new Context(pages);

        assertTrue(new AllPagesComplete().evaluate(ctx));
    }

}