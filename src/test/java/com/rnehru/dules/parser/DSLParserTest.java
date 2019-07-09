package com.rnehru.dules.parser;

import com.rnehru.dules.error.UnrecognisedRuleTypeException;
import com.rnehru.dules.higher.PageRule;
import com.rnehru.dules.rule.Rule;
import com.rnehru.dules.rule.contextual.AllPagesComplete;
import com.rnehru.dules.rule.contextual.PageComplete;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DSLParserTest {

    @Test(expected = UnrecognisedRuleTypeException.class)
    public void parse_throwsException_whenUnparseableRule() {
        String badRule = "boo";
        DSLParser parser = new DSLParser();
        parser.parse(badRule);
    }

    @Test
    public void parse_returnsRuleWhen_ruleIsParseable() {
        Rule allPagesComplete = new AllPagesComplete();
        Rule pageRule = new PageRule(null, allPagesComplete);
        String goodRule = ".page(complete)";
        DSLParser parser = new DSLParser();

        assertEquals(pageRule.getClass(), parser.parse(goodRule).getClass());
    }

}
