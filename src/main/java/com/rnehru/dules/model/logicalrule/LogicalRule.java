package com.rnehru.dules.model.logicalrule;

import com.rnehru.dules.model.Rule;

import java.util.List;

abstract class LogicalRule implements Rule {

    protected List<Rule> rules;

}
