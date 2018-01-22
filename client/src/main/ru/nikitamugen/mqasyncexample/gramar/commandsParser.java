// Generated from commands.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class commandsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, NEWLINE=2, WORD=3, ADD=4, GET=5, DELETE=6;
	public static final int
		RULE_addCommand = 0, RULE_getCommand = 1, RULE_deleteCommand = 2;
	public static final String[] ruleNames = {
		"addCommand", "getCommand", "deleteCommand"
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

	@Override
	public String getGrammarFileName() { return "Commands.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public commandsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AddCommandContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(commandsParser.ADD, 0); }
		public List<TerminalNode> WORD() { return getTokens(commandsParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(commandsParser.WORD, i);
		}
		public AddCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof commandsListener ) ((commandsListener)listener).enterAddCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof commandsListener ) ((commandsListener)listener).exitAddCommand(this);
		}
	}

	public final AddCommandContext addCommand() throws RecognitionException {
		AddCommandContext _localctx = new AddCommandContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_addCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(6);
			match(ADD);
			setState(7);
			match(WORD);
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8);
				match(WORD);
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			}
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

	public static class GetCommandContext extends ParserRuleContext {
		public TerminalNode GET() { return getToken(commandsParser.GET, 0); }
		public List<TerminalNode> WORD() { return getTokens(commandsParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(commandsParser.WORD, i);
		}
		public GetCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof commandsListener ) ((commandsListener)listener).enterGetCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof commandsListener ) ((commandsListener)listener).exitGetCommand(this);
		}
	}

	public final GetCommandContext getCommand() throws RecognitionException {
		GetCommandContext _localctx = new GetCommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_getCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(13);
			match(GET);
			setState(14);
			match(WORD);
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(15);
				match(WORD);
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			}
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

	public static class DeleteCommandContext extends ParserRuleContext {
		public TerminalNode DELETE() { return getToken(commandsParser.DELETE, 0); }
		public List<TerminalNode> WORD() { return getTokens(commandsParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(commandsParser.WORD, i);
		}
		public DeleteCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof commandsListener ) ((commandsListener)listener).enterDeleteCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof commandsListener ) ((commandsListener)listener).exitDeleteCommand(this);
		}
	}

	public final DeleteCommandContext deleteCommand() throws RecognitionException {
		DeleteCommandContext _localctx = new DeleteCommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_deleteCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(20);
			match(DELETE);
			setState(21);
			match(WORD);
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				match(WORD);
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WORD );
			}
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b\36\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\3\2\3\2\3\2\6\2\f\n\2\r\2\16\2\r\3\3\3\3\3\3\6\3\23\n\3\r"+
		"\3\16\3\24\3\4\3\4\3\4\6\4\32\n\4\r\4\16\4\33\3\4\2\2\5\2\4\6\2\2\35\2"+
		"\b\3\2\2\2\4\17\3\2\2\2\6\26\3\2\2\2\b\t\7\6\2\2\t\13\7\5\2\2\n\f\7\5"+
		"\2\2\13\n\3\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\3\3\2\2\2\17"+
		"\20\7\7\2\2\20\22\7\5\2\2\21\23\7\5\2\2\22\21\3\2\2\2\23\24\3\2\2\2\24"+
		"\22\3\2\2\2\24\25\3\2\2\2\25\5\3\2\2\2\26\27\7\b\2\2\27\31\7\5\2\2\30"+
		"\32\7\5\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34"+
		"\7\3\2\2\2\5\r\24\33";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}