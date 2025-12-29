// Generated from C:/Users/Lenovo/IdeaProjects/Antlr/src/main/antlr4/ExampleParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExampleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOCTYPE=1, EXPRESSION=2, STATEMENT=3, COMMENT_JINJA2=4, OPEN_STYLE=5, 
		OPEN_TAG=6, CLOSE_TAG=7, ENTITY=8, TEXT=9, COMMENT=10, LBRACE_HTML=11, 
		WS=12, NEWLINE=13, TAG_NAME=14, EQUALS=15, DOUBLE_QUOTED_VALUE=16, SINGLE_QUOTED_VALUE=17, 
		UNQUOTED_VALUE=18, SLASH=19, SELF_CLOSE=20, TAG_CLOSE=21, COMMENT_=22, 
		WS_IN_TAG=23, CLOSE_STYLE=24, LBRACE=25, RBRACE=26, COLON=27, SEMICOLON=28, 
		STAR=29, COMMA=30, COLOR_HEX=31, CLASS_SELECTOR=32, ID_SELECTOR=33, AT=34, 
		NUMBER_UNIT=35, NUMBER=36, UNIT=37, STRING=38, IDENT=39, OPEN_PARE=40, 
		CLOSE_PARE=41, WS_IN_CSS=42;
	public static final int
		RULE_htmlDocument = 0, RULE_doctype = 1, RULE_element = 2, RULE_htmlElement = 3, 
		RULE_attribute = 4, RULE_attributeValue = 5, RULE_jinja2Rule = 6, RULE_styleElement = 7, 
		RULE_cssStatement = 8, RULE_atRule = 9, RULE_cssInnerBlock = 10, RULE_cssDeclaration = 11, 
		RULE_cssValue = 12, RULE_cssRule = 13, RULE_selectorList = 14, RULE_selector = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"htmlDocument", "doctype", "element", "htmlElement", "attribute", "attributeValue", 
			"jinja2Rule", "styleElement", "cssStatement", "atRule", "cssInnerBlock", 
			"cssDeclaration", "cssValue", "cssRule", "selectorList", "selector"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'<'", "'</'", null, null, null, 
			null, null, null, null, "'='", null, null, null, "'/'", "'/>'", "'>'", 
			null, null, "'</style>'", null, "'}'", "':'", "';'", "'*'", "','", null, 
			null, null, "'@'", null, null, null, null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOCTYPE", "EXPRESSION", "STATEMENT", "COMMENT_JINJA2", "OPEN_STYLE", 
			"OPEN_TAG", "CLOSE_TAG", "ENTITY", "TEXT", "COMMENT", "LBRACE_HTML", 
			"WS", "NEWLINE", "TAG_NAME", "EQUALS", "DOUBLE_QUOTED_VALUE", "SINGLE_QUOTED_VALUE", 
			"UNQUOTED_VALUE", "SLASH", "SELF_CLOSE", "TAG_CLOSE", "COMMENT_", "WS_IN_TAG", 
			"CLOSE_STYLE", "LBRACE", "RBRACE", "COLON", "SEMICOLON", "STAR", "COMMA", 
			"COLOR_HEX", "CLASS_SELECTOR", "ID_SELECTOR", "AT", "NUMBER_UNIT", "NUMBER", 
			"UNIT", "STRING", "IDENT", "OPEN_PARE", "CLOSE_PARE", "WS_IN_CSS"
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
	public String getGrammarFileName() { return "ExampleParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExampleParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlDocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExampleParser.EOF, 0); }
		public DoctypeContext doctype() {
			return getRuleContext(DoctypeContext.class,0);
		}
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public HtmlDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterHtmlDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitHtmlDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitHtmlDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlDocumentContext htmlDocument() throws RecognitionException {
		HtmlDocumentContext _localctx = new HtmlDocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_htmlDocument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOCTYPE) {
				{
				setState(32);
				doctype();
				}
			}

			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3052L) != 0)) {
				{
				{
				setState(35);
				element();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
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
	public static class DoctypeContext extends ParserRuleContext {
		public TerminalNode DOCTYPE() { return getToken(ExampleParser.DOCTYPE, 0); }
		public DoctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doctype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterDoctype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitDoctype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitDoctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoctypeContext doctype() throws RecognitionException {
		DoctypeContext _localctx = new DoctypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_doctype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(DOCTYPE);
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
	public static class ElementContext extends ParserRuleContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public StyleElementContext styleElement() {
			return getRuleContext(StyleElementContext.class,0);
		}
		public TerminalNode EXPRESSION() { return getToken(ExampleParser.EXPRESSION, 0); }
		public TerminalNode STATEMENT() { return getToken(ExampleParser.STATEMENT, 0); }
		public TerminalNode LBRACE_HTML() { return getToken(ExampleParser.LBRACE_HTML, 0); }
		public TerminalNode TEXT() { return getToken(ExampleParser.TEXT, 0); }
		public TerminalNode ENTITY() { return getToken(ExampleParser.ENTITY, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_element);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_TAG:
			case CLOSE_TAG:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				htmlElement();
				}
				break;
			case OPEN_STYLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				styleElement();
				}
				break;
			case EXPRESSION:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				match(EXPRESSION);
				}
				break;
			case STATEMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(48);
				match(STATEMENT);
				}
				break;
			case LBRACE_HTML:
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				match(LBRACE_HTML);
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 6);
				{
				setState(50);
				match(TEXT);
				}
				break;
			case ENTITY:
				enterOuterAlt(_localctx, 7);
				{
				setState(51);
				match(ENTITY);
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
	public static class HtmlElementContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG() { return getToken(ExampleParser.OPEN_TAG, 0); }
		public List<TerminalNode> TAG_NAME() { return getTokens(ExampleParser.TAG_NAME); }
		public TerminalNode TAG_NAME(int i) {
			return getToken(ExampleParser.TAG_NAME, i);
		}
		public List<TerminalNode> TAG_CLOSE() { return getTokens(ExampleParser.TAG_CLOSE); }
		public TerminalNode TAG_CLOSE(int i) {
			return getToken(ExampleParser.TAG_CLOSE, i);
		}
		public TerminalNode CLOSE_TAG() { return getToken(ExampleParser.CLOSE_TAG, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public TerminalNode SELF_CLOSE() { return getToken(ExampleParser.SELF_CLOSE, 0); }
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterHtmlElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitHtmlElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitHtmlElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlElement);
		int _la;
		try {
			int _alt;
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(OPEN_TAG);
				setState(55);
				match(TAG_NAME);
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(56);
					attribute();
					}
					}
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(62);
				match(TAG_CLOSE);
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(63);
						element();
						}
						} 
					}
					setState(68);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				setState(69);
				match(CLOSE_TAG);
				setState(70);
				match(TAG_NAME);
				setState(71);
				match(TAG_CLOSE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(OPEN_TAG);
				setState(73);
				match(TAG_NAME);
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(74);
					attribute();
					}
					}
					setState(79);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(80);
				match(SELF_CLOSE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				match(CLOSE_TAG);
				setState(82);
				match(TAG_NAME);
				setState(83);
				match(TAG_CLOSE);
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
	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode TAG_NAME() { return getToken(ExampleParser.TAG_NAME, 0); }
		public TerminalNode EQUALS() { return getToken(ExampleParser.EQUALS, 0); }
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attribute);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				match(TAG_NAME);
				setState(87);
				match(EQUALS);
				setState(88);
				attributeValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(TAG_NAME);
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
	public static class AttributeValueContext extends ParserRuleContext {
		public TerminalNode DOUBLE_QUOTED_VALUE() { return getToken(ExampleParser.DOUBLE_QUOTED_VALUE, 0); }
		public TerminalNode SINGLE_QUOTED_VALUE() { return getToken(ExampleParser.SINGLE_QUOTED_VALUE, 0); }
		public TerminalNode UNQUOTED_VALUE() { return getToken(ExampleParser.UNQUOTED_VALUE, 0); }
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitAttributeValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitAttributeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attributeValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 458752L) != 0)) ) {
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
	public static class Jinja2RuleContext extends ParserRuleContext {
		public TerminalNode EXPRESSION() { return getToken(ExampleParser.EXPRESSION, 0); }
		public TerminalNode STATEMENT() { return getToken(ExampleParser.STATEMENT, 0); }
		public TerminalNode COMMENT_JINJA2() { return getToken(ExampleParser.COMMENT_JINJA2, 0); }
		public Jinja2RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinja2Rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterJinja2Rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitJinja2Rule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitJinja2Rule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jinja2RuleContext jinja2Rule() throws RecognitionException {
		Jinja2RuleContext _localctx = new Jinja2RuleContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_jinja2Rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0)) ) {
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
	public static class StyleElementContext extends ParserRuleContext {
		public TerminalNode OPEN_STYLE() { return getToken(ExampleParser.OPEN_STYLE, 0); }
		public TerminalNode CLOSE_STYLE() { return getToken(ExampleParser.CLOSE_STYLE, 0); }
		public List<CssStatementContext> cssStatement() {
			return getRuleContexts(CssStatementContext.class);
		}
		public CssStatementContext cssStatement(int i) {
			return getRuleContext(CssStatementContext.class,i);
		}
		public StyleElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterStyleElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitStyleElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitStyleElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StyleElementContext styleElement() throws RecognitionException {
		StyleElementContext _localctx = new StyleElementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_styleElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(OPEN_STYLE);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3878892339200L) != 0)) {
				{
				{
				setState(97);
				cssStatement();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(CLOSE_STYLE);
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
	public static class CssStatementContext extends ParserRuleContext {
		public CssRuleContext cssRule() {
			return getRuleContext(CssRuleContext.class,0);
		}
		public AtRuleContext atRule() {
			return getRuleContext(AtRuleContext.class,0);
		}
		public CssStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterCssStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitCssStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitCssStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssStatementContext cssStatement() throws RecognitionException {
		CssStatementContext _localctx = new CssStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cssStatement);
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
			case CLASS_SELECTOR:
			case ID_SELECTOR:
			case IDENT:
			case OPEN_PARE:
			case CLOSE_PARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				cssRule();
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				atRule();
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
	public static class AtRuleContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(ExampleParser.AT, 0); }
		public TerminalNode IDENT() { return getToken(ExampleParser.IDENT, 0); }
		public CssInnerBlockContext cssInnerBlock() {
			return getRuleContext(CssInnerBlockContext.class,0);
		}
		public SelectorListContext selectorList() {
			return getRuleContext(SelectorListContext.class,0);
		}
		public AtRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterAtRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitAtRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitAtRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtRuleContext atRule() throws RecognitionException {
		AtRuleContext _localctx = new AtRuleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(AT);
			setState(110);
			match(IDENT);
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(111);
				selectorList();
				}
				break;
			}
			setState(114);
			cssInnerBlock();
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
	public static class CssInnerBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ExampleParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ExampleParser.RBRACE, 0); }
		public List<CssDeclarationContext> cssDeclaration() {
			return getRuleContexts(CssDeclarationContext.class);
		}
		public CssDeclarationContext cssDeclaration(int i) {
			return getRuleContext(CssDeclarationContext.class,i);
		}
		public List<CssStatementContext> cssStatement() {
			return getRuleContexts(CssStatementContext.class);
		}
		public CssStatementContext cssStatement(int i) {
			return getRuleContext(CssStatementContext.class,i);
		}
		public CssInnerBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssInnerBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterCssInnerBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitCssInnerBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitCssInnerBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssInnerBlockContext cssInnerBlock() throws RecognitionException {
		CssInnerBlockContext _localctx = new CssInnerBlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cssInnerBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(116);
				cssDeclaration();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(LBRACE);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3878892339200L) != 0)) {
				{
				setState(125);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(123);
					cssStatement();
					}
					break;
				case 2:
					{
					setState(124);
					cssDeclaration();
					}
					break;
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
			match(RBRACE);
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
	public static class CssDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ExampleParser.IDENT, 0); }
		public TerminalNode COLON() { return getToken(ExampleParser.COLON, 0); }
		public TerminalNode SEMICOLON() { return getToken(ExampleParser.SEMICOLON, 0); }
		public List<CssValueContext> cssValue() {
			return getRuleContexts(CssValueContext.class);
		}
		public CssValueContext cssValue(int i) {
			return getRuleContext(CssValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExampleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExampleParser.COMMA, i);
		}
		public CssDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterCssDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitCssDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitCssDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationContext cssDeclaration() throws RecognitionException {
		CssDeclarationContext _localctx = new CssDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cssDeclaration);
		int _la;
		try {
			int _alt;
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(IDENT);
				setState(133);
				match(COLON);
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(134);
					cssValue();
					}
					}
					setState(137); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4365834256384L) != 0) );
				setState(139);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(IDENT);
				setState(142);
				match(COLON);
				setState(144); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(143);
						cssValue();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(146); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				match(IDENT);
				setState(149);
				match(COLON);
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(150);
					cssValue();
					}
					}
					setState(153); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4365834256384L) != 0) );
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(155);
					match(COMMA);
					setState(157); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(156);
						cssValue();
						}
						}
						setState(159); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4365834256384L) != 0) );
					}
					}
					setState(163); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(165);
				match(SEMICOLON);
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
	public static class CssValueContext extends ParserRuleContext {
		public TerminalNode NUMBER_UNIT() { return getToken(ExampleParser.NUMBER_UNIT, 0); }
		public TerminalNode NUMBER() { return getToken(ExampleParser.NUMBER, 0); }
		public TerminalNode UNIT() { return getToken(ExampleParser.UNIT, 0); }
		public TerminalNode COLOR_HEX() { return getToken(ExampleParser.COLOR_HEX, 0); }
		public TerminalNode STRING() { return getToken(ExampleParser.STRING, 0); }
		public TerminalNode IDENT() { return getToken(ExampleParser.IDENT, 0); }
		public TerminalNode OPEN_PARE() { return getToken(ExampleParser.OPEN_PARE, 0); }
		public TerminalNode CLOSE_PARE() { return getToken(ExampleParser.CLOSE_PARE, 0); }
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterCssValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitCssValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitCssValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cssValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4365834256384L) != 0)) ) {
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
	public static class CssRuleContext extends ParserRuleContext {
		public SelectorListContext selectorList() {
			return getRuleContext(SelectorListContext.class,0);
		}
		public CssInnerBlockContext cssInnerBlock() {
			return getRuleContext(CssInnerBlockContext.class,0);
		}
		public CssRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterCssRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitCssRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitCssRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cssRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			selectorList();
			setState(172);
			cssInnerBlock();
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
	public static class SelectorListContext extends ParserRuleContext {
		public List<SelectorContext> selector() {
			return getRuleContexts(SelectorContext.class);
		}
		public SelectorContext selector(int i) {
			return getRuleContext(SelectorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExampleParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExampleParser.COMMA, i);
		}
		public SelectorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterSelectorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitSelectorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitSelectorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorListContext selectorList() throws RecognitionException {
		SelectorListContext _localctx = new SelectorListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_selectorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			selector();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(175);
				match(COMMA);
				setState(176);
				selector();
				}
				}
				setState(181);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SelectorContext extends ParserRuleContext {
		public TerminalNode CLASS_SELECTOR() { return getToken(ExampleParser.CLASS_SELECTOR, 0); }
		public TerminalNode ID_SELECTOR() { return getToken(ExampleParser.ID_SELECTOR, 0); }
		public TerminalNode IDENT() { return getToken(ExampleParser.IDENT, 0); }
		public TerminalNode OPEN_PARE() { return getToken(ExampleParser.OPEN_PARE, 0); }
		public TerminalNode CLOSE_PARE() { return getToken(ExampleParser.CLOSE_PARE, 0); }
		public TerminalNode STAR() { return getToken(ExampleParser.STAR, 0); }
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3861712470016L) != 0)) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001*\u00b9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0003\u0000\"\b\u0000\u0001\u0000\u0005\u0000%\b\u0000\n"+
		"\u0000\f\u0000(\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u00025\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003:\b\u0003\n\u0003\f\u0003=\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003A\b\u0003\n\u0003\f\u0003D\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003L\b\u0003"+
		"\n\u0003\f\u0003O\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003U\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004[\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0005\u0007c\b\u0007\n\u0007\f\u0007f\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003\bl\b\b\u0001\t\u0001\t"+
		"\u0001\t\u0003\tq\b\t\u0001\t\u0001\t\u0001\n\u0005\nv\b\n\n\n\f\ny\t"+
		"\n\u0001\n\u0001\n\u0001\n\u0005\n~\b\n\n\n\f\n\u0081\t\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u0088\b\u000b\u000b"+
		"\u000b\f\u000b\u0089\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0004\u000b\u0091\b\u000b\u000b\u000b\f\u000b\u0092\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0004\u000b\u0098\b\u000b\u000b\u000b\f\u000b"+
		"\u0099\u0001\u000b\u0001\u000b\u0004\u000b\u009e\b\u000b\u000b\u000b\f"+
		"\u000b\u009f\u0004\u000b\u00a2\b\u000b\u000b\u000b\f\u000b\u00a3\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00a8\b\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00b2\b\u000e"+
		"\n\u000e\f\u000e\u00b5\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0000"+
		"\u0000\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e\u0000\u0004\u0001\u0000\u0010\u0012\u0001\u0000"+
		"\u0002\u0004\u0002\u0000\u001f\u001f#)\u0003\u0000\u001d\u001d !\')\u00c4"+
		"\u0000!\u0001\u0000\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u00044"+
		"\u0001\u0000\u0000\u0000\u0006T\u0001\u0000\u0000\u0000\bZ\u0001\u0000"+
		"\u0000\u0000\n\\\u0001\u0000\u0000\u0000\f^\u0001\u0000\u0000\u0000\u000e"+
		"`\u0001\u0000\u0000\u0000\u0010k\u0001\u0000\u0000\u0000\u0012m\u0001"+
		"\u0000\u0000\u0000\u0014w\u0001\u0000\u0000\u0000\u0016\u00a7\u0001\u0000"+
		"\u0000\u0000\u0018\u00a9\u0001\u0000\u0000\u0000\u001a\u00ab\u0001\u0000"+
		"\u0000\u0000\u001c\u00ae\u0001\u0000\u0000\u0000\u001e\u00b6\u0001\u0000"+
		"\u0000\u0000 \"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000\u0000!\"\u0001"+
		"\u0000\u0000\u0000\"&\u0001\u0000\u0000\u0000#%\u0003\u0004\u0002\u0000"+
		"$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000"+
		"\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000(&\u0001\u0000"+
		"\u0000\u0000)*\u0005\u0000\u0000\u0001*\u0001\u0001\u0000\u0000\u0000"+
		"+,\u0005\u0001\u0000\u0000,\u0003\u0001\u0000\u0000\u0000-5\u0003\u0006"+
		"\u0003\u0000.5\u0003\u000e\u0007\u0000/5\u0005\u0002\u0000\u000005\u0005"+
		"\u0003\u0000\u000015\u0005\u000b\u0000\u000025\u0005\t\u0000\u000035\u0005"+
		"\b\u0000\u00004-\u0001\u0000\u0000\u00004.\u0001\u0000\u0000\u00004/\u0001"+
		"\u0000\u0000\u000040\u0001\u0000\u0000\u000041\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000043\u0001\u0000\u0000\u00005\u0005\u0001\u0000"+
		"\u0000\u000067\u0005\u0006\u0000\u00007;\u0005\u000e\u0000\u00008:\u0003"+
		"\b\u0004\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000"+
		"=;\u0001\u0000\u0000\u0000>B\u0005\u0015\u0000\u0000?A\u0003\u0004\u0002"+
		"\u0000@?\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001\u0000"+
		"\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000\u0000DB\u0001"+
		"\u0000\u0000\u0000EF\u0005\u0007\u0000\u0000FG\u0005\u000e\u0000\u0000"+
		"GU\u0005\u0015\u0000\u0000HI\u0005\u0006\u0000\u0000IM\u0005\u000e\u0000"+
		"\u0000JL\u0003\b\u0004\u0000KJ\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000"+
		"\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001\u0000"+
		"\u0000\u0000OM\u0001\u0000\u0000\u0000PU\u0005\u0014\u0000\u0000QR\u0005"+
		"\u0007\u0000\u0000RS\u0005\u000e\u0000\u0000SU\u0005\u0015\u0000\u0000"+
		"T6\u0001\u0000\u0000\u0000TH\u0001\u0000\u0000\u0000TQ\u0001\u0000\u0000"+
		"\u0000U\u0007\u0001\u0000\u0000\u0000VW\u0005\u000e\u0000\u0000WX\u0005"+
		"\u000f\u0000\u0000X[\u0003\n\u0005\u0000Y[\u0005\u000e\u0000\u0000ZV\u0001"+
		"\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[\t\u0001\u0000\u0000\u0000"+
		"\\]\u0007\u0000\u0000\u0000]\u000b\u0001\u0000\u0000\u0000^_\u0007\u0001"+
		"\u0000\u0000_\r\u0001\u0000\u0000\u0000`d\u0005\u0005\u0000\u0000ac\u0003"+
		"\u0010\b\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000"+
		"fd\u0001\u0000\u0000\u0000gh\u0005\u0018\u0000\u0000h\u000f\u0001\u0000"+
		"\u0000\u0000il\u0003\u001a\r\u0000jl\u0003\u0012\t\u0000ki\u0001\u0000"+
		"\u0000\u0000kj\u0001\u0000\u0000\u0000l\u0011\u0001\u0000\u0000\u0000"+
		"mn\u0005\"\u0000\u0000np\u0005\'\u0000\u0000oq\u0003\u001c\u000e\u0000"+
		"po\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000rs\u0003\u0014\n\u0000s\u0013\u0001\u0000\u0000\u0000tv\u0003\u0016"+
		"\u000b\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001"+
		"\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000z\u007f\u0005\u0019\u0000\u0000{~\u0003\u0010"+
		"\b\u0000|~\u0003\u0016\u000b\u0000}{\u0001\u0000\u0000\u0000}|\u0001\u0000"+
		"\u0000\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0082\u0001\u0000\u0000\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u001a\u0000\u0000"+
		"\u0083\u0015\u0001\u0000\u0000\u0000\u0084\u0085\u0005\'\u0000\u0000\u0085"+
		"\u0087\u0005\u001b\u0000\u0000\u0086\u0088\u0003\u0018\f\u0000\u0087\u0086"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u001c\u0000\u0000\u008c\u00a8"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0005\'\u0000\u0000\u008e\u0090\u0005"+
		"\u001b\u0000\u0000\u008f\u0091\u0003\u0018\f\u0000\u0090\u008f\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u00a8\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0005\'\u0000\u0000\u0095\u0097\u0005\u001b\u0000"+
		"\u0000\u0096\u0098\u0003\u0018\f\u0000\u0097\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u00a1\u0001\u0000\u0000\u0000"+
		"\u009b\u009d\u0005\u001e\u0000\u0000\u009c\u009e\u0003\u0018\f\u0000\u009d"+
		"\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f"+
		"\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a1\u009b\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005\u001c\u0000\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7"+
		"\u0084\u0001\u0000\u0000\u0000\u00a7\u008d\u0001\u0000\u0000\u0000\u00a7"+
		"\u0094\u0001\u0000\u0000\u0000\u00a8\u0017\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0007\u0002\u0000\u0000\u00aa\u0019\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0003\u001c\u000e\u0000\u00ac\u00ad\u0003\u0014\n\u0000\u00ad\u001b"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b3\u0003\u001e\u000f\u0000\u00af\u00b0"+
		"\u0005\u001e\u0000\u0000\u00b0\u00b2\u0003\u001e\u000f\u0000\u00b1\u00af"+
		"\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u001d"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b7"+
		"\u0007\u0003\u0000\u0000\u00b7\u001f\u0001\u0000\u0000\u0000\u0015!&4"+
		";BMTZdkpw}\u007f\u0089\u0092\u0099\u009f\u00a3\u00a7\u00b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}