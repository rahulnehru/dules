package com.rnehru.dules.api;

import com.google.common.annotations.VisibleForTesting;
import com.rnehru.dules.error.InvalidRuleFileException;
import com.rnehru.dules.parser.DSLParser;
import com.rnehru.dules.rule.Rule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuleParser implements Parser {

    @VisibleForTesting
    DSLParser parser = new DSLParser();

    public DuleParser() { }

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
    public Map<String, String> parseFile(File file) throws FileNotFoundException, InvalidRuleFileException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            Map<String, String> itemAndRule = new HashMap<>();
            br.lines().forEach(l -> {
                String[] iAndR = l.trim().split(":");
                itemAndRule.put(iAndR[0].trim(), iAndR[1].trim());
            });
            return itemAndRule;
        } catch (Exception e) {
            throw new InvalidRuleFileException();
        }
    }

}

