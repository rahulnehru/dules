package com.rnehru.dules.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DulesParser}.
 */
interface DulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DulesParser#higher}.
	 * @param ctx the parse tree
	 */
	void enterHigher(DulesParser.HigherContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#higher}.
	 * @param ctx the parse tree
	 */
	void exitHigher(DulesParser.HigherContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#pageShowRule}.
	 * @param ctx the parse tree
	 */
	void enterPageShowRule(DulesParser.PageShowRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#pageShowRule}.
	 * @param ctx the parse tree
	 */
	void exitPageShowRule(DulesParser.PageShowRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#questionShowRule}.
	 * @param ctx the parse tree
	 */
	void enterQuestionShowRule(DulesParser.QuestionShowRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#questionShowRule}.
	 * @param ctx the parse tree
	 */
	void exitQuestionShowRule(DulesParser.QuestionShowRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(DulesParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(DulesParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#triggers}.
	 * @param ctx the parse tree
	 */
	void enterTriggers(DulesParser.TriggersContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#triggers}.
	 * @param ctx the parse tree
	 */
	void exitTriggers(DulesParser.TriggersContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#statedriven}.
	 * @param ctx the parse tree
	 */
	void enterStatedriven(DulesParser.StatedrivenContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#statedriven}.
	 * @param ctx the parse tree
	 */
	void exitStatedriven(DulesParser.StatedrivenContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#contextdriven}.
	 * @param ctx the parse tree
	 */
	void enterContextdriven(DulesParser.ContextdrivenContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#contextdriven}.
	 * @param ctx the parse tree
	 */
	void exitContextdriven(DulesParser.ContextdrivenContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#allPagesComplete}.
	 * @param ctx the parse tree
	 */
	void enterAllPagesComplete(DulesParser.AllPagesCompleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#allPagesComplete}.
	 * @param ctx the parse tree
	 */
	void exitAllPagesComplete(DulesParser.AllPagesCompleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#answerDateAfter}.
	 * @param ctx the parse tree
	 */
	void enterAnswerDateAfter(DulesParser.AnswerDateAfterContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#answerDateAfter}.
	 * @param ctx the parse tree
	 */
	void exitAnswerDateAfter(DulesParser.AnswerDateAfterContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#answerDateBefore}.
	 * @param ctx the parse tree
	 */
	void enterAnswerDateBefore(DulesParser.AnswerDateBeforeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#answerDateBefore}.
	 * @param ctx the parse tree
	 */
	void exitAnswerDateBefore(DulesParser.AnswerDateBeforeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#answerExists}.
	 * @param ctx the parse tree
	 */
	void enterAnswerExists(DulesParser.AnswerExistsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#answerExists}.
	 * @param ctx the parse tree
	 */
	void exitAnswerExists(DulesParser.AnswerExistsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#answerIn}.
	 * @param ctx the parse tree
	 */
	void enterAnswerIn(DulesParser.AnswerInContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#answerIn}.
	 * @param ctx the parse tree
	 */
	void exitAnswerIn(DulesParser.AnswerInContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#answerLessThan}.
	 * @param ctx the parse tree
	 */
	void enterAnswerLessThan(DulesParser.AnswerLessThanContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#answerLessThan}.
	 * @param ctx the parse tree
	 */
	void exitAnswerLessThan(DulesParser.AnswerLessThanContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#answerMatches}.
	 * @param ctx the parse tree
	 */
	void enterAnswerMatches(DulesParser.AnswerMatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#answerMatches}.
	 * @param ctx the parse tree
	 */
	void exitAnswerMatches(DulesParser.AnswerMatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#answerMoreThan}.
	 * @param ctx the parse tree
	 */
	void enterAnswerMoreThan(DulesParser.AnswerMoreThanContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#answerMoreThan}.
	 * @param ctx the parse tree
	 */
	void exitAnswerMoreThan(DulesParser.AnswerMoreThanContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#pageComplete}.
	 * @param ctx the parse tree
	 */
	void enterPageComplete(DulesParser.PageCompleteContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#pageComplete}.
	 * @param ctx the parse tree
	 */
	void exitPageComplete(DulesParser.PageCompleteContext ctx);
	/**
	 * Enter a parse tree produced by {@link DulesParser#pageExists}.
	 * @param ctx the parse tree
	 */
	void enterPageExists(DulesParser.PageExistsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DulesParser#pageExists}.
	 * @param ctx the parse tree
	 */
	void exitPageExists(DulesParser.PageExistsContext ctx);
}