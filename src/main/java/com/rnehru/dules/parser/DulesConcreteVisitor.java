package com.rnehru.dules.parser;

import com.rnehru.dules.rule.Rule;
import com.rnehru.dules.rule.contextual.*;

import java.util.ArrayList;

public class DulesConcreteVisitor extends DulesBaseVisitor<Rule> {

    @Override
    public Rule visitHigher(DulesParser.HigherContext ctx) {
        return super.visitHigher(ctx);
    }

    @Override
    public Rule visitPageShowRule(DulesParser.PageShowRuleContext ctx) {
        return super.visitPageShowRule(ctx);
    }

    @Override
    public Rule visitPageExists(DulesParser.PageExistsContext ctx) {
        return new PageExists(ctx.String().getText());
    }

    @Override
    public Rule visitAnswerExists(DulesParser.AnswerExistsContext ctx) {
        return new AnswerExists(
                ctx.String(0).getText(),
                ctx.String(1).getText()
        );
    }

    @Override
    public Rule visitAllPagesComplete(DulesParser.AllPagesCompleteContext ctx) {
        return new AllPagesComplete();
    }

    @Override
    public Rule visitAnswerDateAfter(DulesParser.AnswerDateAfterContext ctx) {
        return new AnswerDateAfter(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                ctx.String(2).getText()
        );
    }

    @Override
    public Rule visitAnswerDateBefore(DulesParser.AnswerDateBeforeContext ctx) {
        return new AnswerDateBefore(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                ctx.String(2).getText()
        );
    }

    @Override
    public Rule visitAnswerLessThan(DulesParser.AnswerLessThanContext ctx) {
        return new AnswerLessThan(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                Integer.parseInt(ctx.Number().getText())
        );
    }

    @Override
    public Rule visitAnswerMoreThan(DulesParser.AnswerMoreThanContext ctx) {
        return new AnswerMoreThan(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                Integer.parseInt(ctx.Number().getText())
        );
    }

    @Override
    public Rule visitAnswerIn(DulesParser.AnswerInContext ctx) {
        return new AnswerIn(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                new ArrayList<>()
        );
    }

    @Override
    public Rule visitAnswerMatches(DulesParser.AnswerMatchesContext ctx) {
        return new AnswerMatches(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                ctx.String(2).getText()
        );
    }

    @Override
    public Rule visitPageComplete(DulesParser.PageCompleteContext ctx) {
        return new PageComplete(ctx.String().getText());
    }

}
