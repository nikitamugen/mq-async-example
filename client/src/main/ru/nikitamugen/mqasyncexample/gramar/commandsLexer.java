// Generated from commands.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class commandsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, NEWLINE=2, WORD=3, ADD=4, GET=5, DELETE=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LOWERCASE", "UPPERCASE", "DIGIT", "WHITESPACE", "NEWLINE", "WORD", "A", 
		"D", "E", "G", "L", "T", "ADD", "GET", "DELETE"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WHITESPACE", "NEWLINE", "WORD", "ADD", "GET", "DELETE"
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


	public commandsLexer(CharStream input) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\bg\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\5\2#\n\2\3\3\5\3"+
		"&\n\3\3\4\3\4\3\5\3\5\3\6\5\6-\n\6\3\6\3\6\6\6\61\n\6\r\6\16\6\62\3\7"+
		"\3\7\3\7\6\78\n\7\r\7\16\79\3\7\6\7=\n\7\r\7\16\7>\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\6\16Q\n\16\r\16\16"+
		"\16R\3\17\3\17\3\17\3\17\6\17Y\n\17\r\17\16\17Z\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\6\20d\n\20\r\20\16\20e\2\2\21\3\2\5\2\7\2\t\3\13\4\r\5\17"+
		"\2\21\2\23\2\25\2\27\2\31\2\33\6\35\7\37\b\3\2\f\5\2c|\u0432\u0451\u0453"+
		"\u0453\5\2C\\\u0403\u0403\u0412\u0431\3\2\62;\4\2\13\13\"\"\4\2CCcc\4"+
		"\2FFff\4\2GGgg\4\2IIii\4\2NNnn\4\2VVvvg\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3\"\3\2\2\2\5%\3\2\2\2\7"+
		"\'\3\2\2\2\t)\3\2\2\2\13\60\3\2\2\2\r\67\3\2\2\2\17@\3\2\2\2\21B\3\2\2"+
		"\2\23D\3\2\2\2\25F\3\2\2\2\27H\3\2\2\2\31J\3\2\2\2\33L\3\2\2\2\35T\3\2"+
		"\2\2\37\\\3\2\2\2!#\t\2\2\2\"!\3\2\2\2#\4\3\2\2\2$&\t\3\2\2%$\3\2\2\2"+
		"&\6\3\2\2\2\'(\t\4\2\2(\b\3\2\2\2)*\t\5\2\2*\n\3\2\2\2+-\7\17\2\2,+\3"+
		"\2\2\2,-\3\2\2\2-.\3\2\2\2.\61\7\f\2\2/\61\7\17\2\2\60,\3\2\2\2\60/\3"+
		"\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\f\3\2\2\2\648\5\3"+
		"\2\2\658\5\5\3\2\668\7a\2\2\67\64\3\2\2\2\67\65\3\2\2\2\67\66\3\2\2\2"+
		"89\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;=\5\t\5\2<;\3\2\2\2=>\3\2\2"+
		"\2><\3\2\2\2>?\3\2\2\2?\16\3\2\2\2@A\t\6\2\2A\20\3\2\2\2BC\t\7\2\2C\22"+
		"\3\2\2\2DE\t\b\2\2E\24\3\2\2\2FG\t\t\2\2G\26\3\2\2\2HI\t\n\2\2I\30\3\2"+
		"\2\2JK\t\13\2\2K\32\3\2\2\2LM\5\17\b\2MN\5\21\t\2NP\5\21\t\2OQ\5\t\5\2"+
		"PO\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\34\3\2\2\2TU\5\25\13\2UV\5\23"+
		"\n\2VX\5\31\r\2WY\5\t\5\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\36"+
		"\3\2\2\2\\]\5\21\t\2]^\5\23\n\2^_\5\27\f\2_`\5\23\n\2`a\5\31\r\2ac\5\23"+
		"\n\2bd\5\t\5\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2f \3\2\2\2\16\2"+
		"\"%,\60\62\679>RZe\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}