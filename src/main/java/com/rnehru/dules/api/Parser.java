package com.rnehru.dules.api;

import com.rnehru.dules.error.InvalidRuleFileException;
import com.rnehru.dules.rule.Rule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public interface Parser {

    Rule parseRule(String dslRule);
    List<Rule> parseRules(List<String> dslRule);
    Map<String, String> parseFile(File file) throws FileNotFoundException, InvalidRuleFileException;

}
