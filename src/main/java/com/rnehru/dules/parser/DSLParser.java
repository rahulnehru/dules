package com.rnehru.dules.parser;

import com.rnehru.dules.error.UnrecognisedRuleTypeException;
import com.rnehru.dules.rule.Rule;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class DSLParser {

    private DulesConcreteVisitor visitor = new DulesConcreteVisitor();

    public Rule parse(String dslRule) throws UnrecognisedRuleTypeException {
        DulesLexer dl = new DulesLexer(CharStreams.fromString(dslRule));
        CommonTokenStream tokens = new CommonTokenStream(dl);
        DulesParser parser = new DulesParser(tokens);
        return visitor.visitHigher(parser.higher());
    }

}
