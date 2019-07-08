package com.rnehru.dules.rule;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RuleTest {

    @Test
    public void contextInvalid_returnsTrue_whenContextIsNull() {
        assertTrue(Rule.contextInvalid(null));
    }

    @Test
    public void contextInvalid_returnsTrue_whenContextHasNullPageList() {
        Context ctx = new Context(null);
        assertTrue(Rule.contextInvalid(ctx));
    }

    @Test
    public void contextInvalid_returnsTrue_whenContextHasEmptyPageList() {
        List<Page> pages = new ArrayList<>();
        Context ctx = new Context(pages);
        assertTrue(Rule.contextInvalid(ctx));
    }

    @Test
    public void contextInvalid_returnsFalse_whenContextHasNonEmptyPageList() {
        List<Page> pages = new ArrayList<>();
        pages.add(new Page("page", new HashMap<>()));
        Context ctx = new Context(pages);
        assertFalse(Rule.contextInvalid(ctx));
    }
}
