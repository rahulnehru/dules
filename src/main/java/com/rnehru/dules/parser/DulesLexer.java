package com.rnehru.dules.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
class DulesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, Complete=4, AND=5, OR=6, NOT=7, Number=8, String=9, 
		Ref=10, Date=11, Und=12, LessThan=13, GreaterThan=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "Complete", "AND", "OR", "NOT", "Number", "String", 
			"Ref", "Date", "Und", "LessThan", "GreaterThan"
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


	public DulesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Dules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20d\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\6\tI"+
		"\n\t\r\t\16\tJ\3\n\6\nN\n\n\r\n\16\nO\3\13\3\13\6\13T\n\13\r\13\16\13"+
		"U\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\2\2\20\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\4"+
		"\3\2\62;\5\2))C\\c|\2f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2"+
		"\2\2\5&\3\2\2\2\7(\3\2\2\2\t\63\3\2\2\2\13<\3\2\2\2\r@\3\2\2\2\17E\3\2"+
		"\2\2\21H\3\2\2\2\23M\3\2\2\2\25Q\3\2\2\2\27W\3\2\2\2\31]\3\2\2\2\33`\3"+
		"\2\2\2\35b\3\2\2\2\37 \7\60\2\2 !\7r\2\2!\"\7c\2\2\"#\7i\2\2#$\7g\2\2"+
		"$%\7*\2\2%\4\3\2\2\2&\'\7+\2\2\'\6\3\2\2\2()\7\60\2\2)*\7s\2\2*+\7w\2"+
		"\2+,\7g\2\2,-\7u\2\2-.\7v\2\2./\7k\2\2/\60\7q\2\2\60\61\7p\2\2\61\62\7"+
		"*\2\2\62\b\3\2\2\2\63\64\7e\2\2\64\65\7q\2\2\65\66\7o\2\2\66\67\7r\2\2"+
		"\678\7n\2\289\7g\2\29:\7v\2\2:;\7g\2\2;\n\3\2\2\2<=\7\"\2\2=>\7(\2\2>"+
		"?\7\"\2\2?\f\3\2\2\2@A\7\"\2\2AB\7~\2\2BC\7~\2\2CD\7\"\2\2D\16\3\2\2\2"+
		"EF\7#\2\2F\20\3\2\2\2GI\t\2\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2"+
		"\2K\22\3\2\2\2LN\t\3\2\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\24\3"+
		"\2\2\2QS\7&\2\2RT\t\3\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V\26"+
		"\3\2\2\2WX\5\21\t\2XY\7/\2\2YZ\5\21\t\2Z[\7/\2\2[\\\5\21\t\2\\\30\3\2"+
		"\2\2]^\7a\2\2^_\7a\2\2_\32\3\2\2\2`a\7>\2\2a\34\3\2\2\2bc\7@\2\2c\36\3"+
		"\2\2\2\6\2JOU\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}