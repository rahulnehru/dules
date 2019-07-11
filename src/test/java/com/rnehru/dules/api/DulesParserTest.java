package com.rnehru.dules.api;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.error.UnrecognisedRuleTypeException;
import com.rnehru.dules.parser.DSLParser;
import com.rnehru.dules.rule.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DulesParserTest {

    class TestRule implements Rule {

        @Override
        public boolean evaluate(Context context) {
            return true;
        }
    }

    @Test
    public void parseRule_returnRule_whenParseable() {
        Rule expected = new TestRule();
        DuleParser p = new DuleParser();
        DSLParser internal = mock(DSLParser.class);
        p.parser = internal;
        when(internal.parse(anyString())).thenReturn(expected);

        assertEquals(expected, p.parseRule("some rule"));
    }

    @Test(expected = UnrecognisedRuleTypeException.class)
    public void parseRule_throwsException_whenRuleNotParseable() {
        DuleParser p = new DuleParser();

        p.parseRule("some bad rule");
    }

    @Test
    public void parseRules_returnsRules_whenParseable() {
        List<String> dslRules = new ArrayList<>();
        dslRules.add("rule1"); dslRules.add("rule2");
        Rule testRule = new TestRule();
        List<Rule> expected = new ArrayList<>();
        expected.add(testRule); expected.add(testRule);
        DuleParser p = new DuleParser();
        DSLParser internal = mock(DSLParser.class);
        p.parser = internal;
        when(internal.parse(anyString())).thenReturn(testRule);

        assertEquals(expected, p.parseRules(dslRules));
        assertEquals(2, p.parseRules(dslRules).size());
    }

    @Test(expected = UnrecognisedRuleTypeException.class)
    public void parseRules_throwsException_whenRuleNotParseable() {
        List<String> dslRules = new ArrayList<>();
        dslRules.add("rule1"); dslRules.add("rule2");
        DuleParser p = new DuleParser();

        p.parseRules(dslRules);
    }

}
