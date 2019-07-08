package com.rnehru.dules.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DulesParser extends org.antlr.v4.runtime.Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, Complete=4, AND=5, OR=6, NOT=7, Number=8, String=9, 
		Ref=10, Date=11, Und=12, LessThan=13, GreaterThan=14;
	public static final int
		RULE_higher = 0, RULE_pageShowRule = 1, RULE_questionShowRule = 2, RULE_rule = 3, 
		RULE_triggers = 4, RULE_statedriven = 5, RULE_contextdriven = 6, RULE_allPagesComplete = 7, 
		RULE_answerDateAfter = 8, RULE_answerDateBefore = 9, RULE_answerExists = 10, 
		RULE_answerIn = 11, RULE_answerLessThan = 12, RULE_answerMatches = 13, 
		RULE_answerMoreThan = 14, RULE_pageComplete = 15, RULE_pageExists = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"higher", "pageShowRule", "questionShowRule", "rule", "triggers", "statedriven", 
			"contextdriven", "allPagesComplete", "answerDateAfter", "answerDateBefore", 
			"answerExists", "answerIn", "answerLessThan", "answerMatches", "answerMoreThan", 
			"pageComplete", "pageExists"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.page('", "')'", "'.question('", "'complete'", "' & '", "' || '", 
			"'!'", null, null, null, null, "'__'", "'<'", "'>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "Complete", "AND", "OR", "NOT", "Number", "String", 
			"Ref", "Date", "Und", "LessThan", "GreaterThan"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Dules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DulesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class HigherContext extends ParserRuleContext {
		public PageShowRuleContext pageShowRule() {
			return getRuleContext(PageShowRuleContext.class,0);
		}
		public QuestionShowRuleContext questionShowRule() {
			return getRuleContext(QuestionShowRuleContext.class,0);
		}
		public HigherContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_higher; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterHigher(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitHigher(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitHigher(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HigherContext higher() throws RecognitionException {
		HigherContext _localctx = new HigherContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_higher);
		try {
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				pageShowRule();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				questionShowRule();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PageShowRuleContext extends ParserRuleContext {
		public RuleContext rule() {
			return getRuleContext(RuleContext.class,0);
		}
		public PageShowRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pageShowRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterPageShowRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitPageShowRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitPageShowRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PageShowRuleContext pageShowRule() throws RecognitionException {
		PageShowRuleContext _localctx = new PageShowRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pageShowRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			rule(0);
			setState(40);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuestionShowRuleContext extends ParserRuleContext {
		public RuleContext rule() {
			return getRuleContext(RuleContext.class,0);
		}
		public QuestionShowRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_questionShowRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterQuestionShowRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitQuestionShowRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitQuestionShowRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionShowRuleContext questionShowRule() throws RecognitionException {
		QuestionShowRuleContext _localctx = new QuestionShowRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_questionShowRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__2);
			setState(43);
			rule(0);
			setState(44);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RuleContext extends ParserRuleContext {
		public TriggersContext triggers() {
			return getRuleContext(TriggersContext.class,0);
		}
		public TerminalNode NOT() { return getToken(DulesParser.NOT, 0); }
		public List<RuleContext> rule() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public TerminalNode AND() { return getToken(DulesParser.AND, 0); }
		public TerminalNode OR() { return getToken(DulesParser.OR, 0); }
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule() throws RecognitionException {
		return rule(0);
	}

	private RuleContext rule(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RuleContext _localctx = new RuleContext(_ctx, _parentState);
		RuleContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_rule, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Complete:
			case String:
				{
				setState(47);
				triggers();
				}
				break;
			case NOT:
				{
				setState(48);
				match(NOT);
				setState(49);
				rule(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(60);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(58);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new RuleContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rule);
						setState(52);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(53);
						match(AND);
						setState(54);
						rule(4);
						}
						break;
					case 2:
						{
						_localctx = new RuleContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_rule);
						setState(55);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(56);
						match(OR);
						setState(57);
						rule(3);
						}
						break;
					}
					} 
				}
				setState(62);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TriggersContext extends ParserRuleContext {
		public StatedrivenContext statedriven() {
			return getRuleContext(StatedrivenContext.class,0);
		}
		public ContextdrivenContext contextdriven() {
			return getRuleContext(ContextdrivenContext.class,0);
		}
		public TriggersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterTriggers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitTriggers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitTriggers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggersContext triggers() throws RecognitionException {
		TriggersContext _localctx = new TriggersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_triggers);
		try {
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Complete:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				statedriven();
				}
				break;
			case String:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				contextdriven();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatedrivenContext extends ParserRuleContext {
		public AllPagesCompleteContext allPagesComplete() {
			return getRuleContext(AllPagesCompleteContext.class,0);
		}
		public PageCompleteContext pageComplete() {
			return getRuleContext(PageCompleteContext.class,0);
		}
		public StatedrivenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statedriven; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterStatedriven(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitStatedriven(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitStatedriven(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatedrivenContext statedriven() throws RecognitionException {
		StatedrivenContext _localctx = new StatedrivenContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statedriven);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				allPagesComplete();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				pageComplete();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContextdrivenContext extends ParserRuleContext {
		public AnswerExistsContext answerExists() {
			return getRuleContext(AnswerExistsContext.class,0);
		}
		public AnswerMatchesContext answerMatches() {
			return getRuleContext(AnswerMatchesContext.class,0);
		}
		public AnswerInContext answerIn() {
			return getRuleContext(AnswerInContext.class,0);
		}
		public AnswerDateBeforeContext answerDateBefore() {
			return getRuleContext(AnswerDateBeforeContext.class,0);
		}
		public AnswerDateAfterContext answerDateAfter() {
			return getRuleContext(AnswerDateAfterContext.class,0);
		}
		public AnswerLessThanContext answerLessThan() {
			return getRuleContext(AnswerLessThanContext.class,0);
		}
		public AnswerMoreThanContext answerMoreThan() {
			return getRuleContext(AnswerMoreThanContext.class,0);
		}
		public PageExistsContext pageExists() {
			return getRuleContext(PageExistsContext.class,0);
		}
		public ContextdrivenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contextdriven; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterContextdriven(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitContextdriven(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitContextdriven(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContextdrivenContext contextdriven() throws RecognitionException {
		ContextdrivenContext _localctx = new ContextdrivenContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_contextdriven);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				answerExists();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				answerMatches();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				answerIn();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				answerDateBefore();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				answerDateAfter();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				answerLessThan();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(77);
				answerMoreThan();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(78);
				pageExists();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AllPagesCompleteContext extends ParserRuleContext {
		public TerminalNode Complete() { return getToken(DulesParser.Complete, 0); }
		public AllPagesCompleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allPagesComplete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterAllPagesComplete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitAllPagesComplete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitAllPagesComplete(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllPagesCompleteContext allPagesComplete() throws RecognitionException {
		AllPagesCompleteContext _localctx = new AllPagesCompleteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_allPagesComplete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(Complete);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnswerDateAfterContext extends ParserRuleContext {
		public List<TerminalNode> String() { return getTokens(DulesParser.String); }
		public TerminalNode String(int i) {
			return getToken(DulesParser.String, i);
		}
		public List<TerminalNode> Und() { return getTokens(DulesParser.Und); }
		public TerminalNode Und(int i) {
			return getToken(DulesParser.Und, i);
		}
		public TerminalNode GreaterThan() { return getToken(DulesParser.GreaterThan, 0); }
		public TerminalNode Date() { return getToken(DulesParser.Date, 0); }
		public AnswerDateAfterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerDateAfter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterAnswerDateAfter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitAnswerDateAfter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitAnswerDateAfter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerDateAfterContext answerDateAfter() throws RecognitionException {
		AnswerDateAfterContext _localctx = new AnswerDateAfterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_answerDateAfter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(String);
			setState(84);
			match(Und);
			setState(85);
			match(String);
			setState(86);
			match(Und);
			setState(87);
			match(GreaterThan);
			setState(88);
			match(Date);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnswerDateBeforeContext extends ParserRuleContext {
		public List<TerminalNode> String() { return getTokens(DulesParser.String); }
		public TerminalNode String(int i) {
			return getToken(DulesParser.String, i);
		}
		public List<TerminalNode> Und() { return getTokens(DulesParser.Und); }
		public TerminalNode Und(int i) {
			return getToken(DulesParser.Und, i);
		}
		public TerminalNode LessThan() { return getToken(DulesParser.LessThan, 0); }
		public TerminalNode Date() { return getToken(DulesParser.Date, 0); }
		public AnswerDateBeforeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerDateBefore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterAnswerDateBefore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitAnswerDateBefore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitAnswerDateBefore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerDateBeforeContext answerDateBefore() throws RecognitionException {
		AnswerDateBeforeContext _localctx = new AnswerDateBeforeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_answerDateBefore);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(String);
			setState(91);
			match(Und);
			setState(92);
			match(String);
			setState(93);
			match(Und);
			setState(94);
			match(LessThan);
			setState(95);
			match(Date);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnswerExistsContext extends ParserRuleContext {
		public List<TerminalNode> String() { return getTokens(DulesParser.String); }
		public TerminalNode String(int i) {
			return getToken(DulesParser.String, i);
		}
		public TerminalNode Und() { return getToken(DulesParser.Und, 0); }
		public AnswerExistsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerExists; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterAnswerExists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitAnswerExists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitAnswerExists(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerExistsContext answerExists() throws RecognitionException {
		AnswerExistsContext _localctx = new AnswerExistsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_answerExists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(String);
			setState(98);
			match(Und);
			setState(99);
			match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnswerInContext extends ParserRuleContext {
		public List<TerminalNode> String() { return getTokens(DulesParser.String); }
		public TerminalNode String(int i) {
			return getToken(DulesParser.String, i);
		}
		public List<TerminalNode> Und() { return getTokens(DulesParser.Und); }
		public TerminalNode Und(int i) {
			return getToken(DulesParser.Und, i);
		}
		public TerminalNode Ref() { return getToken(DulesParser.Ref, 0); }
		public AnswerInContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerIn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterAnswerIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitAnswerIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitAnswerIn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerInContext answerIn() throws RecognitionException {
		AnswerInContext _localctx = new AnswerInContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_answerIn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(String);
			setState(102);
			match(Und);
			setState(103);
			match(String);
			setState(104);
			match(Und);
			setState(105);
			match(Ref);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnswerLessThanContext extends ParserRuleContext {
		public List<TerminalNode> String() { return getTokens(DulesParser.String); }
		public TerminalNode String(int i) {
			return getToken(DulesParser.String, i);
		}
		public List<TerminalNode> Und() { return getTokens(DulesParser.Und); }
		public TerminalNode Und(int i) {
			return getToken(DulesParser.Und, i);
		}
		public TerminalNode LessThan() { return getToken(DulesParser.LessThan, 0); }
		public TerminalNode Number() { return getToken(DulesParser.Number, 0); }
		public AnswerLessThanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerLessThan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterAnswerLessThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitAnswerLessThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitAnswerLessThan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerLessThanContext answerLessThan() throws RecognitionException {
		AnswerLessThanContext _localctx = new AnswerLessThanContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_answerLessThan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(String);
			setState(108);
			match(Und);
			setState(109);
			match(String);
			setState(110);
			match(Und);
			setState(111);
			match(LessThan);
			setState(112);
			match(Number);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnswerMatchesContext extends ParserRuleContext {
		public List<TerminalNode> String() { return getTokens(DulesParser.String); }
		public TerminalNode String(int i) {
			return getToken(DulesParser.String, i);
		}
		public List<TerminalNode> Und() { return getTokens(DulesParser.Und); }
		public TerminalNode Und(int i) {
			return getToken(DulesParser.Und, i);
		}
		public AnswerMatchesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerMatches; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterAnswerMatches(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitAnswerMatches(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitAnswerMatches(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerMatchesContext answerMatches() throws RecognitionException {
		AnswerMatchesContext _localctx = new AnswerMatchesContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_answerMatches);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(String);
			setState(115);
			match(Und);
			setState(116);
			match(String);
			setState(117);
			match(Und);
			setState(118);
			match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnswerMoreThanContext extends ParserRuleContext {
		public List<TerminalNode> String() { return getTokens(DulesParser.String); }
		public TerminalNode String(int i) {
			return getToken(DulesParser.String, i);
		}
		public List<TerminalNode> Und() { return getTokens(DulesParser.Und); }
		public TerminalNode Und(int i) {
			return getToken(DulesParser.Und, i);
		}
		public TerminalNode GreaterThan() { return getToken(DulesParser.GreaterThan, 0); }
		public TerminalNode Number() { return getToken(DulesParser.Number, 0); }
		public AnswerMoreThanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answerMoreThan; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterAnswerMoreThan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitAnswerMoreThan(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitAnswerMoreThan(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnswerMoreThanContext answerMoreThan() throws RecognitionException {
		AnswerMoreThanContext _localctx = new AnswerMoreThanContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_answerMoreThan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(String);
			setState(121);
			match(Und);
			setState(122);
			match(String);
			setState(123);
			match(Und);
			setState(124);
			match(GreaterThan);
			setState(125);
			match(Number);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PageCompleteContext extends ParserRuleContext {
		public TerminalNode Complete() { return getToken(DulesParser.Complete, 0); }
		public TerminalNode Und() { return getToken(DulesParser.Und, 0); }
		public TerminalNode String() { return getToken(DulesParser.String, 0); }
		public PageCompleteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pageComplete; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterPageComplete(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitPageComplete(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitPageComplete(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PageCompleteContext pageComplete() throws RecognitionException {
		PageCompleteContext _localctx = new PageCompleteContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pageComplete);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(Complete);
			setState(128);
			match(Und);
			setState(129);
			match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PageExistsContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(DulesParser.String, 0); }
		public PageExistsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pageExists; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).enterPageExists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DulesListener ) ((DulesListener)listener).exitPageExists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DulesVisitor ) return ((DulesVisitor<? extends T>)visitor).visitPageExists(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PageExistsContext pageExists() throws RecognitionException {
		PageExistsContext _localctx = new PageExistsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_pageExists);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return rule_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rule_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\u0088\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\5\2\'\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5"+
		"\65\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\3\6\3\6\5\6D\n"+
		"\6\3\7\3\7\5\7H\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bR\n\b\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\2\3\b\23\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"\2\2\2\u0083\2&\3\2\2\2\4(\3\2\2\2\6,\3\2\2\2\b\64\3\2\2\2\n"+
		"C\3\2\2\2\fG\3\2\2\2\16Q\3\2\2\2\20S\3\2\2\2\22U\3\2\2\2\24\\\3\2\2\2"+
		"\26c\3\2\2\2\30g\3\2\2\2\32m\3\2\2\2\34t\3\2\2\2\36z\3\2\2\2 \u0081\3"+
		"\2\2\2\"\u0085\3\2\2\2$\'\5\4\3\2%\'\5\6\4\2&$\3\2\2\2&%\3\2\2\2\'\3\3"+
		"\2\2\2()\7\3\2\2)*\5\b\5\2*+\7\4\2\2+\5\3\2\2\2,-\7\5\2\2-.\5\b\5\2./"+
		"\7\4\2\2/\7\3\2\2\2\60\61\b\5\1\2\61\65\5\n\6\2\62\63\7\t\2\2\63\65\5"+
		"\b\5\3\64\60\3\2\2\2\64\62\3\2\2\2\65>\3\2\2\2\66\67\f\5\2\2\678\7\7\2"+
		"\28=\5\b\5\69:\f\4\2\2:;\7\b\2\2;=\5\b\5\5<\66\3\2\2\2<9\3\2\2\2=@\3\2"+
		"\2\2><\3\2\2\2>?\3\2\2\2?\t\3\2\2\2@>\3\2\2\2AD\5\f\7\2BD\5\16\b\2CA\3"+
		"\2\2\2CB\3\2\2\2D\13\3\2\2\2EH\5\20\t\2FH\5 \21\2GE\3\2\2\2GF\3\2\2\2"+
		"H\r\3\2\2\2IR\5\26\f\2JR\5\34\17\2KR\5\30\r\2LR\5\24\13\2MR\5\22\n\2N"+
		"R\5\32\16\2OR\5\36\20\2PR\5\"\22\2QI\3\2\2\2QJ\3\2\2\2QK\3\2\2\2QL\3\2"+
		"\2\2QM\3\2\2\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\17\3\2\2\2ST\7\6\2\2T\21"+
		"\3\2\2\2UV\7\13\2\2VW\7\16\2\2WX\7\13\2\2XY\7\16\2\2YZ\7\20\2\2Z[\7\r"+
		"\2\2[\23\3\2\2\2\\]\7\13\2\2]^\7\16\2\2^_\7\13\2\2_`\7\16\2\2`a\7\17\2"+
		"\2ab\7\r\2\2b\25\3\2\2\2cd\7\13\2\2de\7\16\2\2ef\7\13\2\2f\27\3\2\2\2"+
		"gh\7\13\2\2hi\7\16\2\2ij\7\13\2\2jk\7\16\2\2kl\7\f\2\2l\31\3\2\2\2mn\7"+
		"\13\2\2no\7\16\2\2op\7\13\2\2pq\7\16\2\2qr\7\17\2\2rs\7\n\2\2s\33\3\2"+
		"\2\2tu\7\13\2\2uv\7\16\2\2vw\7\13\2\2wx\7\16\2\2xy\7\13\2\2y\35\3\2\2"+
		"\2z{\7\13\2\2{|\7\16\2\2|}\7\13\2\2}~\7\16\2\2~\177\7\20\2\2\177\u0080"+
		"\7\n\2\2\u0080\37\3\2\2\2\u0081\u0082\7\6\2\2\u0082\u0083\7\16\2\2\u0083"+
		"\u0084\7\13\2\2\u0084!\3\2\2\2\u0085\u0086\7\13\2\2\u0086#\3\2\2\2\t&"+
		"\64<>CGQ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}