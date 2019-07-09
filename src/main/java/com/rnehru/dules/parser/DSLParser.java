package com.rnehru.dules.parser;

import com.rnehru.dules.rule.Rule;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class DSLParser {

    public static void main(String[] args) {
        String s = ".page(p__q__>1 & p)";

        DulesLexer dl = new DulesLexer(CharStreams.fromString(s));

        CommonTokenStream tokens = new CommonTokenStream(dl);

        DulesParser parser = new DulesParser(tokens);


        DulesConcreteVisitor visitor = new DulesConcreteVisitor();

        Rule r = visitor.visitHigher(parser.higher());

        System.out.println(r);


    }
}
