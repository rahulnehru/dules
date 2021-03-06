package com.rnehru.dules.parser;

import com.rnehru.dules.error.UnrecognisedRuleTypeException;
import com.rnehru.dules.higher.PageRule;
import com.rnehru.dules.higher.QuestionRule;
import com.rnehru.dules.parser.DulesParser.*;
import com.rnehru.dules.rule.Rule;
import com.rnehru.dules.rule.contextual.*;
import com.rnehru.dules.rule.logical.And;
import com.rnehru.dules.rule.logical.Not;
import com.rnehru.dules.rule.logical.Or;

import static java.util.stream.Collectors.toList;

class DulesConcreteVisitor extends DulesBaseVisitor<Rule> {

    protected DulesConcreteVisitor() {}

    @Override
    public Rule visitHigher(HigherContext ctx) {
        if (null != ctx.pageShowRule()) {
            return ctx.pageShowRule().accept(this);
        } else if (null != ctx.questionShowRule()) {
            return ctx.questionShowRule().accept(this);
        } else {
            throw new UnrecognisedRuleTypeException();
        }
    }

    @Override
    public Rule visitPageShowRule(PageShowRuleContext ctx) {
        return new PageRule(ctx.rule().accept(this));
    }

    @Override
    public Rule visitQuestionShowRule(QuestionShowRuleContext ctx) {
        return new QuestionRule(ctx.rule().accept(this));
    }

    @Override
    public Rule visitRule(RuleContext ctx) {
        if (null != ctx.AND()) {
            return new And(ctx.rule().stream().map(ruleContext -> ruleContext.accept(this)).collect(toList()));
        } else if (null != ctx.OR()) {
            return new Or(ctx.rule().stream().map(ruleContext -> ruleContext.accept(this)).collect(toList()));
        } else if (null != ctx.NOT()) {
            return new Not(ctx.rule(0).accept(this));
        } else if (null != ctx.rule(0)) {
            return ctx.rule(0).accept(this);
        } else {
            return super.visitRule(ctx);
        }
    }

    @Override
    public Rule visitPageExists(PageExistsContext ctx) {
        return new PageExists(ctx.String().getText());
    }

    @Override
    public Rule visitAnswerExists(AnswerExistsContext ctx) {
        return new AnswerExists(
                ctx.String(0).getText(),
                ctx.String(1).getText()
        );
    }

    @Override
    public Rule visitAllPagesComplete(AllPagesCompleteContext ctx) {
        return new AllPagesComplete();
    }

    @Override
    public Rule visitAnswerDateAfter(AnswerDateAfterContext ctx) {
        return new AnswerDateAfter(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                ctx.Date().getText()
        );
    }

    @Override
    public Rule visitAnswerDateBefore(AnswerDateBeforeContext ctx) {
        return new AnswerDateBefore(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                ctx.Date().getText()
        );
    }

    @Override
    public Rule visitAnswerLessThan(AnswerLessThanContext ctx) {
        return new AnswerLessThan(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                Integer.parseInt(ctx.Number().getText())
        );
    }

    @Override
    public Rule visitAnswerMoreThan(AnswerMoreThanContext ctx) {
        return new AnswerMoreThan(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                Integer.parseInt(ctx.Number().getText())
        );
    }

    @Override
    public Rule visitAnswerIn(AnswerInContext ctx) {
        return new AnswerIn(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                ctx.Ref().getText()
        );
    }

    @Override
    public Rule visitAnswerMatches(AnswerMatchesContext ctx) {
        return new AnswerMatches(
                ctx.String(0).getText(),
                ctx.String(1).getText(),
                ctx.String(2).getText()
        );
    }

    @Override
    public Rule visitPageComplete(PageCompleteContext ctx) {
        return new PageComplete(ctx.String().getText());
    }

}
