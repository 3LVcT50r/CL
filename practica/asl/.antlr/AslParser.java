// Generated from /home/victor/uni/3q2/CL/practica/asl/Asl.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AslParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, ASSIGN=8, EQUAL=9, 
		DIFF=10, NOT=11, AND=12, OR=13, PLUS=14, MINUS=15, MUL=16, DIV=17, MOD=18, 
		LS=19, BS=20, LE=21, BE=22, VAR=23, INT=24, BOOL=25, FLOAT=26, CHAR=27, 
		ARRAY=28, OF=29, RETURN=30, IF=31, THEN=32, ELSE=33, ENDIF=34, WHILE=35, 
		DO=36, ENDWHILE=37, FUNC=38, ENDFUNC=39, READ=40, WRITE=41, INTVAL=42, 
		FLOATVAL=43, CHARVAL=44, BOOLVAL=45, ID=46, STRING=47, COMMENT=48, WS=49;
	public static final int
		RULE_program = 0, RULE_function = 1, RULE_parameter_decl = 2, RULE_declarations = 3, 
		RULE_variable_decl = 4, RULE_type = 5, RULE_array_type = 6, RULE_basic_type = 7, 
		RULE_statements = 8, RULE_statement = 9, RULE_left_expr = 10, RULE_expr = 11, 
		RULE_ident = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "function", "parameter_decl", "declarations", "variable_decl", 
			"type", "array_type", "basic_type", "statements", "statement", "left_expr", 
			"expr", "ident"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "':'", "'['", "']'", "';'", "'='", "'=='", 
			"'!='", "'not'", "'and'", "'or'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'<'", "'>'", "'<='", "'>='", "'var'", "'int'", "'bool'", "'float'", 
			"'char'", "'array'", "'of'", "'return'", "'if'", "'then'", "'else'", 
			"'endif'", "'while'", "'do'", "'endwhile'", "'func'", "'endfunc'", "'read'", 
			"'write'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "ASSIGN", "EQUAL", "DIFF", 
			"NOT", "AND", "OR", "PLUS", "MINUS", "MUL", "DIV", "MOD", "LS", "BS", 
			"LE", "BE", "VAR", "INT", "BOOL", "FLOAT", "CHAR", "ARRAY", "OF", "RETURN", 
			"IF", "THEN", "ELSE", "ENDIF", "WHILE", "DO", "ENDWHILE", "FUNC", "ENDFUNC", 
			"READ", "WRITE", "INTVAL", "FLOATVAL", "CHARVAL", "BOOLVAL", "ID", "STRING", 
			"COMMENT", "WS"
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
	public String getGrammarFileName() { return "Asl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AslParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(AslParser.EOF, 0); }
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				function();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FUNC );
			setState(31);
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(AslParser.FUNC, 0); }
		public TerminalNode ID() { return getToken(AslParser.ID, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode ENDFUNC() { return getToken(AslParser.ENDFUNC, 0); }
		public List<Parameter_declContext> parameter_decl() {
			return getRuleContexts(Parameter_declContext.class);
		}
		public Parameter_declContext parameter_decl(int i) {
			return getRuleContext(Parameter_declContext.class,i);
		}
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(FUNC);
			setState(34);
			match(ID);
			setState(35);
			match(T__0);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(36);
				parameter_decl();
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(37);
					match(T__1);
					setState(38);
					parameter_decl();
					}
					}
					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(46);
			match(T__2);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(47);
				match(T__3);
				setState(48);
				basic_type();
				}
			}

			setState(51);
			declarations();
			setState(52);
			statements();
			setState(53);
			match(ENDFUNC);
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

	public static class Parameter_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AslParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Parameter_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_decl; }
	}

	public final Parameter_declContext parameter_decl() throws RecognitionException {
		Parameter_declContext _localctx = new Parameter_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_parameter_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(ID);
			setState(56);
			match(T__3);
			setState(57);
			type();
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

	public static class DeclarationsContext extends ParserRuleContext {
		public List<Variable_declContext> variable_decl() {
			return getRuleContexts(Variable_declContext.class);
		}
		public Variable_declContext variable_decl(int i) {
			return getRuleContext(Variable_declContext.class,i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR) {
				{
				{
				setState(59);
				variable_decl();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Variable_declContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(AslParser.VAR, 0); }
		public List<TerminalNode> ID() { return getTokens(AslParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(AslParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Variable_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_decl; }
	}

	public final Variable_declContext variable_decl() throws RecognitionException {
		Variable_declContext _localctx = new Variable_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variable_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(VAR);
			setState(66);
			match(ID);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(67);
				match(T__1);
				setState(68);
				match(ID);
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(T__3);
			setState(75);
			type();
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

	public static class TypeContext extends ParserRuleContext {
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case FLOAT:
			case CHAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				basic_type();
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				array_type();
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

	public static class Array_typeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(AslParser.ARRAY, 0); }
		public TerminalNode INTVAL() { return getToken(AslParser.INTVAL, 0); }
		public TerminalNode OF() { return getToken(AslParser.OF, 0); }
		public Basic_typeContext basic_type() {
			return getRuleContext(Basic_typeContext.class,0);
		}
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(ARRAY);
			setState(82);
			match(T__4);
			setState(83);
			match(INTVAL);
			setState(84);
			match(T__5);
			setState(85);
			match(OF);
			setState(86);
			basic_type();
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

	public static class Basic_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(AslParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(AslParser.BOOL, 0); }
		public TerminalNode FLOAT() { return getToken(AslParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(AslParser.CHAR, 0); }
		public Basic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_type; }
	}

	public final Basic_typeContext basic_type() throws RecognitionException {
		Basic_typeContext _localctx = new Basic_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_basic_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << FLOAT) | (1L << CHAR))) != 0)) ) {
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << IF) | (1L << WHILE) | (1L << READ) | (1L << WRITE) | (1L << ID))) != 0)) {
				{
				{
				setState(90);
				statement();
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class ProcCallContext extends StatementContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ProcCallContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class WriteExprContext extends StatementContext {
		public TerminalNode WRITE() { return getToken(AslParser.WRITE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WriteExprContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class WhileStmtContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(AslParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(AslParser.DO, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode ENDWHILE() { return getToken(AslParser.ENDWHILE, 0); }
		public WhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class IfStmtContext extends StatementContext {
		public TerminalNode IF() { return getToken(AslParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(AslParser.THEN, 0); }
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public TerminalNode ENDIF() { return getToken(AslParser.ENDIF, 0); }
		public TerminalNode ELSE() { return getToken(AslParser.ELSE, 0); }
		public IfStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ReadStmtContext extends StatementContext {
		public TerminalNode READ() { return getToken(AslParser.READ, 0); }
		public Left_exprContext left_expr() {
			return getRuleContext(Left_exprContext.class,0);
		}
		public ReadStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class AssignStmtContext extends StatementContext {
		public Left_exprContext left_expr() {
			return getRuleContext(Left_exprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(AslParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class ReturnExprContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(AslParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnExprContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class WriteStringContext extends StatementContext {
		public TerminalNode WRITE() { return getToken(AslParser.WRITE, 0); }
		public TerminalNode STRING() { return getToken(AslParser.STRING, 0); }
		public WriteStringContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new AssignStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				left_expr();
				setState(97);
				match(ASSIGN);
				setState(98);
				expr(0);
				setState(99);
				match(T__6);
				}
				break;
			case 2:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(IF);
				setState(102);
				expr(0);
				setState(103);
				match(THEN);
				setState(104);
				statements();
				setState(110);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ENDIF:
					{
					setState(105);
					match(ENDIF);
					}
					break;
				case ELSE:
					{
					setState(106);
					match(ELSE);
					setState(107);
					statements();
					setState(108);
					match(ENDIF);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(WHILE);
				setState(113);
				expr(0);
				setState(114);
				match(DO);
				setState(115);
				statements();
				setState(116);
				match(ENDWHILE);
				}
				break;
			case 4:
				_localctx = new ProcCallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				ident();
				setState(119);
				match(T__0);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << PLUS) | (1L << MINUS) | (1L << INTVAL) | (1L << FLOATVAL) | (1L << CHARVAL) | (1L << BOOLVAL) | (1L << ID))) != 0)) {
					{
					setState(120);
					expr(0);
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(121);
						match(T__1);
						setState(122);
						expr(0);
						}
						}
						setState(127);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(130);
				match(T__2);
				setState(131);
				match(T__6);
				}
				break;
			case 5:
				_localctx = new ReadStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(READ);
				setState(134);
				left_expr();
				setState(135);
				match(T__6);
				}
				break;
			case 6:
				_localctx = new WriteExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(137);
				match(WRITE);
				setState(138);
				expr(0);
				setState(139);
				match(T__6);
				}
				break;
			case 7:
				_localctx = new WriteStringContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(141);
				match(WRITE);
				setState(142);
				match(STRING);
				setState(143);
				match(T__6);
				}
				break;
			case 8:
				_localctx = new ReturnExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(144);
				match(RETURN);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << PLUS) | (1L << MINUS) | (1L << INTVAL) | (1L << FLOATVAL) | (1L << CHARVAL) | (1L << BOOLVAL) | (1L << ID))) != 0)) {
					{
					setState(145);
					expr(0);
					}
				}

				setState(148);
				match(T__6);
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

	public static class Left_exprContext extends ParserRuleContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Left_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_left_expr; }
	}

	public final Left_exprContext left_expr() throws RecognitionException {
		Left_exprContext _localctx = new Left_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_left_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			ident();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(152);
				match(T__4);
				setState(153);
				expr(0);
				setState(154);
				match(T__5);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BooleanContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(AslParser.AND, 0); }
		public TerminalNode OR() { return getToken(AslParser.OR, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ExprIdentContext extends ExprContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ExprIdentContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ArithmeticContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(AslParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(AslParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(AslParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(AslParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(AslParser.MINUS, 0); }
		public ArithmeticContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class RelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(AslParser.EQUAL, 0); }
		public TerminalNode LS() { return getToken(AslParser.LS, 0); }
		public TerminalNode BS() { return getToken(AslParser.BS, 0); }
		public TerminalNode LE() { return getToken(AslParser.LE, 0); }
		public TerminalNode BE() { return getToken(AslParser.BE, 0); }
		public TerminalNode DIFF() { return getToken(AslParser.DIFF, 0); }
		public RelationalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ArrayIndexContext extends ExprContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayIndexContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class FuncCallContext extends ExprContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncCallContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(AslParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(AslParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(AslParser.PLUS, 0); }
		public UnaryContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParenthesisContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ValueContext extends ExprContext {
		public TerminalNode INTVAL() { return getToken(AslParser.INTVAL, 0); }
		public TerminalNode FLOATVAL() { return getToken(AslParser.FLOATVAL, 0); }
		public TerminalNode CHARVAL() { return getToken(AslParser.CHARVAL, 0); }
		public TerminalNode BOOLVAL() { return getToken(AslParser.BOOLVAL, 0); }
		public ValueContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(159);
				match(T__0);
				setState(160);
				expr(0);
				setState(161);
				match(T__2);
				}
				break;
			case 2:
				{
				_localctx = new ArrayIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				ident();
				setState(164);
				match(T__4);
				setState(165);
				expr(0);
				setState(166);
				match(T__5);
				}
				break;
			case 3:
				{
				_localctx = new FuncCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				ident();
				setState(169);
				match(T__0);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << NOT) | (1L << PLUS) | (1L << MINUS) | (1L << INTVAL) | (1L << FLOATVAL) | (1L << CHARVAL) | (1L << BOOLVAL) | (1L << ID))) != 0)) {
					{
					setState(170);
					expr(0);
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(171);
						match(T__1);
						setState(172);
						expr(0);
						}
						}
						setState(177);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(180);
				match(T__2);
				}
				break;
			case 4:
				{
				_localctx = new UnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				((UnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
					((UnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(183);
				expr(8);
				}
				break;
			case 5:
				{
				_localctx = new ValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTVAL) | (1L << FLOATVAL) | (1L << CHARVAL) | (1L << BOOLVAL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 6:
				{
				_localctx = new ExprIdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				ident();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(203);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(189);
						((ArithmeticContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((ArithmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(190);
						expr(8);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(192);
						((ArithmeticContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ArithmeticContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(193);
						expr(7);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(194);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(195);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << DIFF) | (1L << LS) | (1L << BS) | (1L << LE) | (1L << BE))) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(196);
						expr(6);
						}
						break;
					case 4:
						{
						_localctx = new BooleanContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(198);
						((BooleanContext)_localctx).op = match(AND);
						setState(199);
						expr(5);
						}
						break;
					case 5:
						{
						_localctx = new BooleanContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(200);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(201);
						((BooleanContext)_localctx).op = match(OR);
						setState(202);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(AslParser.ID, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(ID);
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
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u00d5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\6\2\36\n\2\r\2\16\2\37\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\5\3/\n\3\3\3\3\3\3\3\5\3"+
		"\64\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\7\5?\n\5\f\5\16\5B\13\5\3"+
		"\6\3\6\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\6\3\6\3\6\3\7\3\7\5\7R\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\7\n^\n\n\f\n\16\na\13\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13q"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13~\n\13"+
		"\f\13\16\13\u0081\13\13\5\13\u0083\n\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0095\n\13\3\13"+
		"\5\13\u0098\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u009f\n\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00b0\n\r\f\r\16\r\u00b3"+
		"\13\r\5\r\u00b5\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bd\n\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ce\n\r\f\r\16"+
		"\r\u00d1\13\r\3\16\3\16\3\16\2\3\30\17\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\2\b\3\2\32\35\4\2\r\r\20\21\3\2,/\3\2\22\24\3\2\20\21\4\2\13\f\25\30"+
		"\2\u00e7\2\35\3\2\2\2\4#\3\2\2\2\69\3\2\2\2\b@\3\2\2\2\nC\3\2\2\2\fQ\3"+
		"\2\2\2\16S\3\2\2\2\20Z\3\2\2\2\22_\3\2\2\2\24\u0097\3\2\2\2\26\u0099\3"+
		"\2\2\2\30\u00bc\3\2\2\2\32\u00d2\3\2\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36"+
		"\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!\"\7\2\2\3\"\3\3\2\2\2"+
		"#$\7(\2\2$%\7\60\2\2%.\7\3\2\2&+\5\6\4\2\'(\7\4\2\2(*\5\6\4\2)\'\3\2\2"+
		"\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,/\3\2\2\2-+\3\2\2\2.&\3\2\2\2./\3\2\2"+
		"\2/\60\3\2\2\2\60\63\7\5\2\2\61\62\7\6\2\2\62\64\5\20\t\2\63\61\3\2\2"+
		"\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\5\b\5\2\66\67\5\22\n\2\678\7)\2\2"+
		"8\5\3\2\2\29:\7\60\2\2:;\7\6\2\2;<\5\f\7\2<\7\3\2\2\2=?\5\n\6\2>=\3\2"+
		"\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\t\3\2\2\2B@\3\2\2\2CD\7\31\2\2DI\7"+
		"\60\2\2EF\7\4\2\2FH\7\60\2\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J"+
		"L\3\2\2\2KI\3\2\2\2LM\7\6\2\2MN\5\f\7\2N\13\3\2\2\2OR\5\20\t\2PR\5\16"+
		"\b\2QO\3\2\2\2QP\3\2\2\2R\r\3\2\2\2ST\7\36\2\2TU\7\7\2\2UV\7,\2\2VW\7"+
		"\b\2\2WX\7\37\2\2XY\5\20\t\2Y\17\3\2\2\2Z[\t\2\2\2[\21\3\2\2\2\\^\5\24"+
		"\13\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\23\3\2\2\2a_\3\2\2\2b"+
		"c\5\26\f\2cd\7\n\2\2de\5\30\r\2ef\7\t\2\2f\u0098\3\2\2\2gh\7!\2\2hi\5"+
		"\30\r\2ij\7\"\2\2jp\5\22\n\2kq\7$\2\2lm\7#\2\2mn\5\22\n\2no\7$\2\2oq\3"+
		"\2\2\2pk\3\2\2\2pl\3\2\2\2q\u0098\3\2\2\2rs\7%\2\2st\5\30\r\2tu\7&\2\2"+
		"uv\5\22\n\2vw\7\'\2\2w\u0098\3\2\2\2xy\5\32\16\2y\u0082\7\3\2\2z\177\5"+
		"\30\r\2{|\7\4\2\2|~\5\30\r\2}{\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0082z\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\5\2\2\u0085\u0086\7\t"+
		"\2\2\u0086\u0098\3\2\2\2\u0087\u0088\7*\2\2\u0088\u0089\5\26\f\2\u0089"+
		"\u008a\7\t\2\2\u008a\u0098\3\2\2\2\u008b\u008c\7+\2\2\u008c\u008d\5\30"+
		"\r\2\u008d\u008e\7\t\2\2\u008e\u0098\3\2\2\2\u008f\u0090\7+\2\2\u0090"+
		"\u0091\7\61\2\2\u0091\u0098\7\t\2\2\u0092\u0094\7 \2\2\u0093\u0095\5\30"+
		"\r\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0098\7\t\2\2\u0097b\3\2\2\2\u0097g\3\2\2\2\u0097r\3\2\2\2\u0097x\3\2"+
		"\2\2\u0097\u0087\3\2\2\2\u0097\u008b\3\2\2\2\u0097\u008f\3\2\2\2\u0097"+
		"\u0092\3\2\2\2\u0098\25\3\2\2\2\u0099\u009e\5\32\16\2\u009a\u009b\7\7"+
		"\2\2\u009b\u009c\5\30\r\2\u009c\u009d\7\b\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u009a\3\2\2\2\u009e\u009f\3\2\2\2\u009f\27\3\2\2\2\u00a0\u00a1\b\r\1"+
		"\2\u00a1\u00a2\7\3\2\2\u00a2\u00a3\5\30\r\2\u00a3\u00a4\7\5\2\2\u00a4"+
		"\u00bd\3\2\2\2\u00a5\u00a6\5\32\16\2\u00a6\u00a7\7\7\2\2\u00a7\u00a8\5"+
		"\30\r\2\u00a8\u00a9\7\b\2\2\u00a9\u00bd\3\2\2\2\u00aa\u00ab\5\32\16\2"+
		"\u00ab\u00b4\7\3\2\2\u00ac\u00b1\5\30\r\2\u00ad\u00ae\7\4\2\2\u00ae\u00b0"+
		"\5\30\r\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2"+
		"\u00b1\u00b2\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00ac"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\5\2\2\u00b7"+
		"\u00bd\3\2\2\2\u00b8\u00b9\t\3\2\2\u00b9\u00bd\5\30\r\n\u00ba\u00bd\t"+
		"\4\2\2\u00bb\u00bd\5\32\16\2\u00bc\u00a0\3\2\2\2\u00bc\u00a5\3\2\2\2\u00bc"+
		"\u00aa\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2"+
		"\2\2\u00bd\u00cf\3\2\2\2\u00be\u00bf\f\t\2\2\u00bf\u00c0\t\5\2\2\u00c0"+
		"\u00ce\5\30\r\n\u00c1\u00c2\f\b\2\2\u00c2\u00c3\t\6\2\2\u00c3\u00ce\5"+
		"\30\r\t\u00c4\u00c5\f\7\2\2\u00c5\u00c6\t\7\2\2\u00c6\u00ce\5\30\r\b\u00c7"+
		"\u00c8\f\6\2\2\u00c8\u00c9\7\16\2\2\u00c9\u00ce\5\30\r\7\u00ca\u00cb\f"+
		"\5\2\2\u00cb\u00cc\7\17\2\2\u00cc\u00ce\5\30\r\6\u00cd\u00be\3\2\2\2\u00cd"+
		"\u00c1\3\2\2\2\u00cd\u00c4\3\2\2\2\u00cd\u00c7\3\2\2\2\u00cd\u00ca\3\2"+
		"\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\31\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7\60\2\2\u00d3\33\3\2\2\2"+
		"\25\37+.\63@IQ_p\177\u0082\u0094\u0097\u009e\u00b1\u00b4\u00bc\u00cd\u00cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}