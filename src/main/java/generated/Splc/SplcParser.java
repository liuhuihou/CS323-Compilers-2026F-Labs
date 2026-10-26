// Generated from Splc.g4 by ANTLR 4.13.2
package generated.Splc;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SplcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RETURN=1, ASSIGN=2, PLUS=3, MINUS=4, STAR=5, DIV=6, SEMI=7, COMMA=8, LPAREN=9, 
		RPAREN=10, LBRACE=11, RBRACE=12, LBRACK=13, RBRACK=14, INT=15, CHAR=16, 
		VOID=17, Identifier=18, NUMBER=19, CHAR_VALUE=20, WS=21;
	public static final int
		RULE_program = 0, RULE_globalDef = 1, RULE_specifier = 2, RULE_funcArgs = 3, 
		RULE_statement = 4, RULE_expression = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "globalDef", "specifier", "funcArgs", "statement", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'return'", "'='", "'+'", "'-'", "'*'", "'/'", "';'", "','", "'('", 
			"')'", "'{'", "'}'", "'['", "']'", "'int'", "'char'", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "RETURN", "ASSIGN", "PLUS", "MINUS", "STAR", "DIV", "SEMI", "COMMA", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "INT", "CHAR", 
			"VOID", "Identifier", "NUMBER", "CHAR_VALUE", "WS"
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
	public String getGrammarFileName() { return "Splc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SplcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SplcParser.EOF, 0); }
		public List<GlobalDefContext> globalDef() {
			return getRuleContexts(GlobalDefContext.class);
		}
		public GlobalDefContext globalDef(int i) {
			return getRuleContext(GlobalDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) {
				{
				{
				setState(12);
				globalDef();
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(18);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalDefContext extends ParserRuleContext {
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SplcParser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(SplcParser.LPAREN, 0); }
		public FuncArgsContext funcArgs() {
			return getRuleContext(FuncArgsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SplcParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(SplcParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SplcParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(SplcParser.SEMI, 0); }
		public GlobalDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterGlobalDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitGlobalDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitGlobalDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalDefContext globalDef() throws RecognitionException {
		GlobalDefContext _localctx = new GlobalDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalDef);
		int _la;
		try {
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				specifier();
				setState(21);
				match(Identifier);
				setState(22);
				match(LPAREN);
				setState(23);
				funcArgs();
				setState(24);
				match(RPAREN);
				setState(25);
				match(LBRACE);
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2066946L) != 0)) {
					{
					{
					setState(26);
					statement();
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(32);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				specifier();
				setState(35);
				match(Identifier);
				setState(36);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SpecifierContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SplcParser.INT, 0); }
		public TerminalNode CHAR() { return getToken(SplcParser.CHAR, 0); }
		public TerminalNode VOID() { return getToken(SplcParser.VOID, 0); }
		public SpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitSpecifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecifierContext specifier() throws RecognitionException {
		SpecifierContext _localctx = new SpecifierContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class FuncArgsContext extends ParserRuleContext {
		public List<SpecifierContext> specifier() {
			return getRuleContexts(SpecifierContext.class);
		}
		public SpecifierContext specifier(int i) {
			return getRuleContext(SpecifierContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(SplcParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(SplcParser.Identifier, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SplcParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SplcParser.COMMA, i);
		}
		public FuncArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterFuncArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitFuncArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitFuncArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncArgsContext funcArgs() throws RecognitionException {
		FuncArgsContext _localctx = new FuncArgsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 229376L) != 0)) {
				{
				setState(42);
				specifier();
				setState(43);
				match(Identifier);
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(44);
					match(COMMA);
					setState(45);
					specifier();
					setState(46);
					match(Identifier);
					}
					}
					setState(52);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CombineStmtContext extends StatementContext {
		public TerminalNode LBRACE() { return getToken(SplcParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SplcParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CombineStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterCombineStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitCombineStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitCombineStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableStmtContext extends StatementContext {
		public SpecifierContext specifier() {
			return getRuleContext(SpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(SplcParser.Identifier, 0); }
		public TerminalNode SEMI() { return getToken(SplcParser.SEMI, 0); }
		public TerminalNode ASSIGN() { return getToken(SplcParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocalVariableStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterLocalVariableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitLocalVariableStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitLocalVariableStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(SplcParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SplcParser.SEMI, 0); }
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStmtContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(SplcParser.SEMI, 0); }
		public ExpressionStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterExpressionStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitExpressionStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitExpressionStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		int _la;
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				_localctx = new CombineStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(LBRACE);
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2066946L) != 0)) {
					{
					{
					setState(56);
					statement();
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(62);
				match(RBRACE);
				}
				break;
			case INT:
			case CHAR:
			case VOID:
				_localctx = new LocalVariableStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				specifier();
				setState(64);
				match(Identifier);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(65);
					match(ASSIGN);
					setState(66);
					expression(0);
					}
				}

				setState(69);
				match(SEMI);
				}
				break;
			case RETURN:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(RETURN);
				setState(72);
				expression(0);
				setState(73);
				match(SEMI);
				}
				break;
			case LPAREN:
			case Identifier:
			case NUMBER:
			case CHAR_VALUE:
				_localctx = new ExpressionStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				expression(0);
				setState(76);
				match(SEMI);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(SplcParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(SplcParser.RPAREN, 0); }
		public TerminalNode Identifier() { return getToken(SplcParser.Identifier, 0); }
		public TerminalNode NUMBER() { return getToken(SplcParser.NUMBER, 0); }
		public TerminalNode CHAR_VALUE() { return getToken(SplcParser.CHAR_VALUE, 0); }
		public TerminalNode STAR() { return getToken(SplcParser.STAR, 0); }
		public TerminalNode DIV() { return getToken(SplcParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(SplcParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(SplcParser.MINUS, 0); }
		public TerminalNode ASSIGN() { return getToken(SplcParser.ASSIGN, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SplcListener ) ((SplcListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SplcVisitor ) return ((SplcVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(81);
				match(LPAREN);
				setState(82);
				expression(0);
				setState(83);
				match(RPAREN);
				}
				break;
			case Identifier:
				{
				setState(85);
				match(Identifier);
				}
				break;
			case NUMBER:
				{
				setState(86);
				match(NUMBER);
				}
				break;
			case CHAR_VALUE:
				{
				setState(87);
				match(CHAR_VALUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(99);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(90);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(91);
						_la = _input.LA(1);
						if ( !(_la==STAR || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(92);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(93);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(94);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(95);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(96);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(97);
						match(ASSIGN);
						setState(98);
						expression(1);
						}
						break;
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0015i\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000\f\u0000"+
		"\u0011\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u001c\b\u0001"+
		"\n\u0001\f\u0001\u001f\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\'\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u00031\b\u0003\n\u0003\f\u00034\t\u0003\u0003\u00036\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0005\u0004:\b\u0004\n\u0004\f\u0004=\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"D\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004O\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005Y\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005d\b\u0005\n\u0005\f\u0005g\t\u0005\u0001\u0005"+
		"\u0000\u0001\n\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0003\u0001\u0000"+
		"\u000f\u0011\u0001\u0000\u0005\u0006\u0001\u0000\u0003\u0004r\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u0004(\u0001\u0000"+
		"\u0000\u0000\u00065\u0001\u0000\u0000\u0000\bN\u0001\u0000\u0000\u0000"+
		"\nX\u0001\u0000\u0000\u0000\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001"+
		"\u0000\u0000\u0000\u000e\u0011\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000"+
		"\u0000\u0000\u000f\u0010\u0001\u0000\u0000\u0000\u0010\u0012\u0001\u0000"+
		"\u0000\u0000\u0011\u000f\u0001\u0000\u0000\u0000\u0012\u0013\u0005\u0000"+
		"\u0000\u0001\u0013\u0001\u0001\u0000\u0000\u0000\u0014\u0015\u0003\u0004"+
		"\u0002\u0000\u0015\u0016\u0005\u0012\u0000\u0000\u0016\u0017\u0005\t\u0000"+
		"\u0000\u0017\u0018\u0003\u0006\u0003\u0000\u0018\u0019\u0005\n\u0000\u0000"+
		"\u0019\u001d\u0005\u000b\u0000\u0000\u001a\u001c\u0003\b\u0004\u0000\u001b"+
		"\u001a\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d"+
		"\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e"+
		" \u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000 !\u0005"+
		"\f\u0000\u0000!\'\u0001\u0000\u0000\u0000\"#\u0003\u0004\u0002\u0000#"+
		"$\u0005\u0012\u0000\u0000$%\u0005\u0007\u0000\u0000%\'\u0001\u0000\u0000"+
		"\u0000&\u0014\u0001\u0000\u0000\u0000&\"\u0001\u0000\u0000\u0000\'\u0003"+
		"\u0001\u0000\u0000\u0000()\u0007\u0000\u0000\u0000)\u0005\u0001\u0000"+
		"\u0000\u0000*+\u0003\u0004\u0002\u0000+2\u0005\u0012\u0000\u0000,-\u0005"+
		"\b\u0000\u0000-.\u0003\u0004\u0002\u0000./\u0005\u0012\u0000\u0000/1\u0001"+
		"\u0000\u0000\u00000,\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000036\u0001\u0000\u0000"+
		"\u000042\u0001\u0000\u0000\u00005*\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u00006\u0007\u0001\u0000\u0000\u00007;\u0005\u000b\u0000\u0000"+
		"8:\u0003\b\u0004\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000"+
		";9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000>O\u0005\f\u0000\u0000?@\u0003\u0004\u0002"+
		"\u0000@C\u0005\u0012\u0000\u0000AB\u0005\u0002\u0000\u0000BD\u0003\n\u0005"+
		"\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0001\u0000"+
		"\u0000\u0000EF\u0005\u0007\u0000\u0000FO\u0001\u0000\u0000\u0000GH\u0005"+
		"\u0001\u0000\u0000HI\u0003\n\u0005\u0000IJ\u0005\u0007\u0000\u0000JO\u0001"+
		"\u0000\u0000\u0000KL\u0003\n\u0005\u0000LM\u0005\u0007\u0000\u0000MO\u0001"+
		"\u0000\u0000\u0000N7\u0001\u0000\u0000\u0000N?\u0001\u0000\u0000\u0000"+
		"NG\u0001\u0000\u0000\u0000NK\u0001\u0000\u0000\u0000O\t\u0001\u0000\u0000"+
		"\u0000PQ\u0006\u0005\uffff\uffff\u0000QR\u0005\t\u0000\u0000RS\u0003\n"+
		"\u0005\u0000ST\u0005\n\u0000\u0000TY\u0001\u0000\u0000\u0000UY\u0005\u0012"+
		"\u0000\u0000VY\u0005\u0013\u0000\u0000WY\u0005\u0014\u0000\u0000XP\u0001"+
		"\u0000\u0000\u0000XU\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"XW\u0001\u0000\u0000\u0000Ye\u0001\u0000\u0000\u0000Z[\n\u0003\u0000\u0000"+
		"[\\\u0007\u0001\u0000\u0000\\d\u0003\n\u0005\u0004]^\n\u0002\u0000\u0000"+
		"^_\u0007\u0002\u0000\u0000_d\u0003\n\u0005\u0003`a\n\u0001\u0000\u0000"+
		"ab\u0005\u0002\u0000\u0000bd\u0003\n\u0005\u0001cZ\u0001\u0000\u0000\u0000"+
		"c]\u0001\u0000\u0000\u0000c`\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000"+
		"\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000f\u000b\u0001"+
		"\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000\u000b\u000f\u001d&25;CNX"+
		"ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}