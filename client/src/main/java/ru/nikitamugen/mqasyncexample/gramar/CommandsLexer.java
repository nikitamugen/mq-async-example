// Generated from Commands.g4 by ANTLR 4.5.1
package ru.nikitamugen.mqasyncexample.gramar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CommandsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, ADD=3, DELETE=4, GET=5, HELP=6, EXIT=7, QUIT=8, WORD=9, 
		WS=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "A", "D", "E", "L", "T", "G", "H", "P", "X", "I", "Q", 
		"U", "ADD", "DELETE", "GET", "HELP", "EXIT", "QUIT", "WORD", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'q'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, "ADD", "DELETE", "GET", "HELP", "EXIT", "QUIT", "WORD", 
		"WS"
	};
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


	public CommandsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Commands.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\fu\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\6\26k\n\26\r\26\16\26l\3\27"+
		"\6\27p\n\27\r\27\16\27q\3\27\3\27\2\2\30\3\3\5\4\7\2\t\2\13\2\r\2\17\2"+
		"\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\5!\6#\7%\b\'\t)\n+\13-\f\3\2\20"+
		"\4\2CCcc\4\2FFff\4\2GGgg\4\2NNnn\4\2VVvv\4\2IIii\4\2JJjj\4\2RRrr\4\2Z"+
		"Zzz\4\2KKkk\4\2SSss\4\2WWww\t\2\62;C\\aac|\u0403\u0403\u0412\u0431\u0453"+
		"\u0453\5\2\13\f\17\17\"\"j\2\3\3\2\2\2\2\5\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\3/\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2\2\13\67\3\2\2\2\r9"+
		"\3\2\2\2\17;\3\2\2\2\21=\3\2\2\2\23?\3\2\2\2\25A\3\2\2\2\27C\3\2\2\2\31"+
		"E\3\2\2\2\33G\3\2\2\2\35I\3\2\2\2\37K\3\2\2\2!O\3\2\2\2#V\3\2\2\2%Z\3"+
		"\2\2\2\'_\3\2\2\2)d\3\2\2\2+j\3\2\2\2-o\3\2\2\2/\60\7A\2\2\60\4\3\2\2"+
		"\2\61\62\7s\2\2\62\6\3\2\2\2\63\64\t\2\2\2\64\b\3\2\2\2\65\66\t\3\2\2"+
		"\66\n\3\2\2\2\678\t\4\2\28\f\3\2\2\29:\t\5\2\2:\16\3\2\2\2;<\t\6\2\2<"+
		"\20\3\2\2\2=>\t\7\2\2>\22\3\2\2\2?@\t\b\2\2@\24\3\2\2\2AB\t\t\2\2B\26"+
		"\3\2\2\2CD\t\n\2\2D\30\3\2\2\2EF\t\13\2\2F\32\3\2\2\2GH\t\f\2\2H\34\3"+
		"\2\2\2IJ\t\r\2\2J\36\3\2\2\2KL\5\7\4\2LM\5\t\5\2MN\5\t\5\2N \3\2\2\2O"+
		"P\5\t\5\2PQ\5\13\6\2QR\5\r\7\2RS\5\13\6\2ST\5\17\b\2TU\5\13\6\2U\"\3\2"+
		"\2\2VW\5\21\t\2WX\5\13\6\2XY\5\17\b\2Y$\3\2\2\2Z[\5\23\n\2[\\\5\13\6\2"+
		"\\]\5\r\7\2]^\5\25\13\2^&\3\2\2\2_`\5\13\6\2`a\5\27\f\2ab\5\31\r\2bc\5"+
		"\17\b\2c(\3\2\2\2de\5\33\16\2ef\5\35\17\2fg\5\31\r\2gh\5\17\b\2h*\3\2"+
		"\2\2ik\t\16\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m,\3\2\2\2np\t"+
		"\17\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\b\27\2\2t"+
		".\3\2\2\2\5\2lq\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}