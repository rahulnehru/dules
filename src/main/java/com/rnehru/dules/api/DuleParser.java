package com.rnehru.dules.api;

import com.rnehru.dules.parser.Parser;
import com.rnehru.dules.rule.Rule;

class DuleParser {

    private Parser parser = new Parser();

    public Rule parse(String ruleRep) {
        return parser.parse(ruleRep);
    }
}
