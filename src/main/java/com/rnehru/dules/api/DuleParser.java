package com.rnehru.dules.api;

import com.rnehru.dules.parser.DSLParser;
import com.rnehru.dules.rule.Rule;

import java.util.List;
import java.util.stream.Collectors;

public class DuleParser {

    DSLParser parser = new DSLParser();

    public Rule parseRule(String dslRule) {
        return parser.parse(dslRule);
    }

    public List<Rule> parseRules(List<String> dslRules) {
        return dslRules
                .stream()
                .map(dslRule -> parser.parse(dslRule))
                .collect(Collectors.toList());
    }

}

