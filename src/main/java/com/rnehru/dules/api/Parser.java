package com.rnehru.dules.api;

import com.rnehru.dules.rule.Rule;

import java.io.File;
import java.util.List;

public interface Parser {

    public Rule parseRule(String dslRule);
    public List<Rule> parseRules(List<String> dslRule);

}
