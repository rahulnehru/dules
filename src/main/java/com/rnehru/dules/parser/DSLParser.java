package com.rnehru.dules.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.Arrays;

public class DSLParser {

    public static void main(String[] args) {
        String s = ".page(p && p_qn_a)";

        DulesLexer dl = new DulesLexer(CharStreams.fromString(s));

        CommonTokenStream tokens = new CommonTokenStream(dl);

        DulesParser parser = new DulesParser(tokens);

        System.out.println(Arrays.toString(parser.getRuleNames()));
    }
}
