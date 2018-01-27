// Generated from Commands.g4 by ANTLR 4.7.1
package ru.nikitamugen.mqasyncexample.gramar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CommandsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, ADD=3, DELETE=4, GET=5, HELP=6, EXIT=7, QUIT=8, WORD=9, 
		WS=10;
	public static final int
		RULE_command = 0, RULE_addCommand = 1, RULE_deleteCommand = 2, RULE_getCommand = 3, 
		RULE_helpCommand = 4, RULE_exitCommand = 5, RULE_code = 6, RULE_value = 7;
	public static final String[] ruleNames = {
		"command", "addCommand", "deleteCommand", "getCommand", "helpCommand", 
		"exitCommand", "code", "value"
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

	@Override
	public String getGrammarFileName() { return "Commands.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CommandsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CommandContext extends ParserRuleContext {
		public AddCommandContext addCommand() {
			return getRuleContext(AddCommandContext.class,0);
		}
		public DeleteCommandContext deleteCommand() {
			return getRuleContext(DeleteCommandContext.class,0);
		}
		public GetCommandContext getCommand() {
			return getRuleContext(GetCommandContext.class,0);
		}
		public HelpCommandContext helpCommand() {
			return getRuleContext(HelpCommandContext.class,0);
		}
		public ExitCommandContext exitCommand() {
			return getRuleContext(ExitCommandContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommandsVisitor ) return ((CommandsVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
				{
				setState(16);
				addCommand();
				}
				break;
			case DELETE:
				{
				setState(17);
				deleteCommand();
				}
				break;
			case GET:
				{
				setState(18);
				getCommand();
				}
				break;
			case T__0:
			case HELP:
				{
				setState(19);
				helpCommand();
				}
				break;
			case T__1:
			case EXIT:
			case QUIT:
				{
				setState(20);
				exitCommand();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AddCommandContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(CommandsParser.ADD, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public AddCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterAddCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitAddCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommandsVisitor ) return ((CommandsVisitor<? extends T>)visitor).visitAddCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddCommandContext addCommand() throws RecognitionException {
		AddCommandContext _localctx = new AddCommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_addCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(23);
			match(ADD);
			setState(24);
			code();
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				value();
				}
				}
				setState(28); 
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
		public TerminalNode DELETE() { return getToken(CommandsParser.DELETE, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public DeleteCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterDeleteCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitDeleteCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommandsVisitor ) return ((CommandsVisitor<? extends T>)visitor).visitDeleteCommand(this);
			else return visitor.visitChildren(this);
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
			setState(30);
			match(DELETE);
			setState(31);
			code();
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				value();
				}
				}
				setState(35); 
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
		public TerminalNode GET() { return getToken(CommandsParser.GET, 0); }
		public CodeContext code() {
			return getRuleContext(CodeContext.class,0);
		}
		public GetCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterGetCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitGetCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommandsVisitor ) return ((CommandsVisitor<? extends T>)visitor).visitGetCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetCommandContext getCommand() throws RecognitionException {
		GetCommandContext _localctx = new GetCommandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_getCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(37);
			match(GET);
			setState(38);
			code();
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

	public static class HelpCommandContext extends ParserRuleContext {
		public TerminalNode HELP() { return getToken(CommandsParser.HELP, 0); }
		public HelpCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_helpCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterHelpCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitHelpCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommandsVisitor ) return ((CommandsVisitor<? extends T>)visitor).visitHelpCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HelpCommandContext helpCommand() throws RecognitionException {
		HelpCommandContext _localctx = new HelpCommandContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_helpCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==HELP) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ExitCommandContext extends ParserRuleContext {
		public TerminalNode EXIT() { return getToken(CommandsParser.EXIT, 0); }
		public TerminalNode QUIT() { return getToken(CommandsParser.QUIT, 0); }
		public ExitCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exitCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterExitCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitExitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommandsVisitor ) return ((CommandsVisitor<? extends T>)visitor).visitExitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitCommandContext exitCommand() throws RecognitionException {
		ExitCommandContext _localctx = new ExitCommandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exitCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << EXIT) | (1L << QUIT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class CodeContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(CommandsParser.WORD, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommandsVisitor ) return ((CommandsVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(WORD);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(CommandsParser.WORD, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CommandsListener ) ((CommandsListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CommandsVisitor ) return ((CommandsVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(WORD);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f\63\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3"+
		"\2\5\2\30\n\2\3\3\3\3\3\3\6\3\35\n\3\r\3\16\3\36\3\4\3\4\3\4\6\4$\n\4"+
		"\r\4\16\4%\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\2\2\n\2\4\6"+
		"\b\n\f\16\20\2\4\4\2\3\3\b\b\4\2\4\4\t\n\2\60\2\27\3\2\2\2\4\31\3\2\2"+
		"\2\6 \3\2\2\2\b\'\3\2\2\2\n*\3\2\2\2\f,\3\2\2\2\16.\3\2\2\2\20\60\3\2"+
		"\2\2\22\30\5\4\3\2\23\30\5\6\4\2\24\30\5\b\5\2\25\30\5\n\6\2\26\30\5\f"+
		"\7\2\27\22\3\2\2\2\27\23\3\2\2\2\27\24\3\2\2\2\27\25\3\2\2\2\27\26\3\2"+
		"\2\2\30\3\3\2\2\2\31\32\7\5\2\2\32\34\5\16\b\2\33\35\5\20\t\2\34\33\3"+
		"\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\5\3\2\2\2 !\7\6\2"+
		"\2!#\5\16\b\2\"$\5\20\t\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\7"+
		"\3\2\2\2\'(\7\7\2\2()\5\16\b\2)\t\3\2\2\2*+\t\2\2\2+\13\3\2\2\2,-\t\3"+
		"\2\2-\r\3\2\2\2./\7\13\2\2/\17\3\2\2\2\60\61\7\13\2\2\61\21\3\2\2\2\5"+
		"\27\36%";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}