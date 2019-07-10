package com.rnehru.dules.api;

import com.rnehru.dules.rule.Rule;

import java.util.List;

public interface Parser {

    Rule parseRule(String dslRule);
    List<Rule> parseRules(List<String> dslRule);

}
