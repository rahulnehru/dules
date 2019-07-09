package com.rnehru.dules.api;

import com.rnehru.dules.parser.DSLParser;
import com.rnehru.dules.rule.Rule;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class DuleParser implements Parser {

    DSLParser parser = new DSLParser();

    @Override
    public Rule parseRule(String dslRule) {
        return parser.parse(dslRule);
    }

    @Override
    public List<Rule> parseRules(List<String> dslRules) {
        return dslRules
                .stream()
                .map(dslRule -> parser.parse(dslRule))
                .collect(Collectors.toList());
    }

    @Override
    public List<Rule> parseRules(File file) {
        return null;
    }


}

