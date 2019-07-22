package com.rnehru.dules.api;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.error.InvalidRuleFileException;
import com.rnehru.dules.error.UnrecognisedRuleTypeException;
import com.rnehru.dules.parser.DSLParser;
import com.rnehru.dules.rule.Rule;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
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

    @Test
    public void parseFile_returnsMapOfItemsAndRules_whenSuppliedWithAValidFile() throws FileNotFoundException, InvalidRuleFileException {
        File f = new File("src/test/resources/rules.txt");
        DuleParser p = new DuleParser();
        Map<String, String> items = p.parseFile(f);

        assertTrue(items.containsKey("pageB"));
        assertEquals(".page(pageA__questionA__answerB)" ,items.get("pageB"));
        assertTrue(items.containsKey("pageB_questionTwo"));
        assertEquals(".question(pageB__questionA__answerYes)" ,items.get("pageB_questionTwo"));
        assertTrue(items.containsKey("pageB_questionThree"));
        assertEquals(".question(pageB__questionA__answerNo)" ,items.get("pageB_questionThree"));
    }

    @Test
    public void parseFile_returnsEmptyMapOfItemsAndRules_whenFileIsEmpty() throws FileNotFoundException, InvalidRuleFileException {
        File f = new File("src/test/resources/emptyrules.txt");
        DuleParser p = new DuleParser();
        Map<String, String> items = p.parseFile(f);
        assertTrue(items.isEmpty());
    }

    @Test(expected = InvalidRuleFileException.class)
    public void parseFile_throwsIOOBException_whenFileIsNotFormattedCorrectly() throws FileNotFoundException, InvalidRuleFileException {
        File f = new File("src/test/resources/badrules.txt");
        DuleParser p = new DuleParser();
        p.parseFile(f);
    }

    @Test(expected = FileNotFoundException.class)
    public void parseFile_throwsFNFException_whenFileDoesNotExist() throws FileNotFoundException, InvalidRuleFileException {
        File f = new File("blaa");
        DuleParser p = new DuleParser();
        p.parseFile(f);
    }

}
