package com.rnehru.dules.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DulesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
interface DulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DulesParser#higher}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHigher(DulesParser.HigherContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#pageShowRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPageShowRule(DulesParser.PageShowRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#questionShowRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionShowRule(DulesParser.QuestionShowRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(DulesParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#triggers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTriggers(DulesParser.TriggersContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#statedriven}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatedriven(DulesParser.StatedrivenContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#contextdriven}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContextdriven(DulesParser.ContextdrivenContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#allPagesComplete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllPagesComplete(DulesParser.AllPagesCompleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#answerDateAfter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerDateAfter(DulesParser.AnswerDateAfterContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#answerDateBefore}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerDateBefore(DulesParser.AnswerDateBeforeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#answerExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerExists(DulesParser.AnswerExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#answerIn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerIn(DulesParser.AnswerInContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#answerLessThan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerLessThan(DulesParser.AnswerLessThanContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#answerMatches}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerMatches(DulesParser.AnswerMatchesContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#answerMoreThan}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswerMoreThan(DulesParser.AnswerMoreThanContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#pageComplete}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPageComplete(DulesParser.PageCompleteContext ctx);
	/**
	 * Visit a parse tree produced by {@link DulesParser#pageExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPageExists(DulesParser.PageExistsContext ctx);
}