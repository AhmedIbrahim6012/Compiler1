// Generated from C:/Users/Lenovo/IdeaProjects/Antlr/src/main/antlr4/ExampleParser.g4 by ANTLR 4.13.2


package antlr;      
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import antlr.ExampleParser;
import antlr.ExampleParserListener;
import antlr.ExampleParserVisitor;
@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExampleParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EXPRESSION=1, STATEMENT=2, COMMENT_JINJA2=3, DOCTYPE=4, OPEN_STYLE=5, 
		CLOSE_STYLE=6, OPEN_TAG=7, CLOSE_TAG=8, ENTITY=9, TEXT=10, COMMENT=11, 
		LBRACE_HTML=12, WS=13, NEWLINE=14, EXPRESSION_=15, STATEMENT_=16, TAG_NAME=17, 
		EQUALS=18, DOUBLE_QUOTED_VALUE=19, SINGLE_QUOTED_VALUE=20, UNQUOTED_VALUE=21, 
		SLASH=22, SELF_CLOSE=23, TAG_CLOSE=24, COMMENT_=25, WS_IN_TAG=26, LBRACE=27, 
		RBRACE=28, COLON=29, SEMICOLON=30, COMMA=31, STAR=32, AT=33, COLOR_HEX=34, 
		NUMBER_UNIT=35, NUMBER=36, UNIT=37, STRING=38, IDENT=39, WS_CSS=40, OPEN_PARE=41, 
		CLOSE_PARE=42, CLASS_SELECTOR=43, ID_SELECTOR=44;
	public static final int
		RULE_htmlDocument = 0, RULE_cssFile = 1, RULE_doctype = 2, RULE_element = 3, 
		RULE_htmlElement = 4, RULE_attribute = 5, RULE_attributeValue = 6, RULE_jinja2Rule = 7, 
		RULE_styleElement = 8, RULE_cssStatement = 9, RULE_atRule = 10, RULE_cssInnerBlock = 11, 
		RULE_cssDeclaration = 12, RULE_cssValue = 13, RULE_cssRule = 14, RULE_selectorList = 15, 
		RULE_selector = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"htmlDocument", "cssFile", "doctype", "element", "htmlElement", "attribute", 
			"attributeValue", "jinja2Rule", "styleElement", "cssStatement", "atRule", 
			"cssInnerBlock", "cssDeclaration", "cssValue", "cssRule", "selectorList", 
			"selector"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, "'</style>'", "'<'", "'</'", null, 
			null, null, null, null, null, null, null, null, "'='", null, null, null, 
			"'/'", "'/>'", "'>'", null, null, null, "'}'", "':'", "';'", "','", "'*'", 
			"'@'", null, null, null, null, null, null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "EXPRESSION", "STATEMENT", "COMMENT_JINJA2", "DOCTYPE", "OPEN_STYLE", 
			"CLOSE_STYLE", "OPEN_TAG", "CLOSE_TAG", "ENTITY", "TEXT", "COMMENT", 
			"LBRACE_HTML", "WS", "NEWLINE", "EXPRESSION_", "STATEMENT_", "TAG_NAME", 
			"EQUALS", "DOUBLE_QUOTED_VALUE", "SINGLE_QUOTED_VALUE", "UNQUOTED_VALUE", 
			"SLASH", "SELF_CLOSE", "TAG_CLOSE", "COMMENT_", "WS_IN_TAG", "LBRACE", 
			"RBRACE", "COLON", "SEMICOLON", "COMMA", "STAR", "AT", "COLOR_HEX", "NUMBER_UNIT", 
			"NUMBER", "UNIT", "STRING", "IDENT", "WS_CSS", "OPEN_PARE", "CLOSE_PARE", 
			"CLASS_SELECTOR", "ID_SELECTOR"
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
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public DoctypeContext doctype() {
			return getRuleContext(DoctypeContext.class,0);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(34);
					element();
					}
					} 
				}
				setState(39);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOCTYPE) {
				{
				setState(40);
				doctype();
				}
			}

			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6054L) != 0)) {
				{
				{
				setState(43);
				element();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
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
	public static class CssFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExampleParser.EOF, 0); }
		public List<CssStatementContext> cssStatement() {
			return getRuleContexts(CssStatementContext.class);
		}
		public CssStatementContext cssStatement(int i) {
			return getRuleContext(CssStatementContext.class,i);
		}
		public CssFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterCssFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitCssFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitCssFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssFileContext cssFile() throws RecognitionException {
		CssFileContext _localctx = new CssFileContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cssFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33547989549056L) != 0)) {
				{
				{
				setState(51);
				cssStatement();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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

        public List<ElementContext> element() {
            return getRuleContexts(ElementContext.class);
        }
    }

	public final DoctypeContext doctype() throws RecognitionException {
		DoctypeContext _localctx = new DoctypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_doctype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
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
		enterRule(_localctx, 6, RULE_element);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_TAG:
			case CLOSE_TAG:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				htmlElement();
				}
				break;
			case OPEN_STYLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				styleElement();
				}
				break;
			case EXPRESSION:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				match(EXPRESSION);
				}
				break;
			case STATEMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				match(STATEMENT);
				}
				break;
			case LBRACE_HTML:
				enterOuterAlt(_localctx, 5);
				{
				setState(65);
				match(LBRACE_HTML);
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 6);
				{
				setState(66);
				match(TEXT);
				}
				break;
			case ENTITY:
				enterOuterAlt(_localctx, 7);
				{
				setState(67);
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
		enterRule(_localctx, 8, RULE_htmlElement);
		int _la;
		try {
			int _alt;
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(OPEN_TAG);
				setState(71);
				match(TAG_NAME);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(72);
					attribute();
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				match(TAG_CLOSE);
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(79);
						element();
						}
						} 
					}
					setState(84);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(85);
				match(CLOSE_TAG);
				setState(86);
				match(TAG_NAME);
				setState(87);
				match(TAG_CLOSE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(OPEN_TAG);
				setState(89);
				match(TAG_NAME);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(90);
					attribute();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
				match(SELF_CLOSE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(CLOSE_TAG);
				setState(98);
				match(TAG_NAME);
				setState(99);
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
		enterRule(_localctx, 10, RULE_attribute);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(TAG_NAME);
				setState(103);
				match(EQUALS);
				setState(104);
				attributeValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
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
		enterRule(_localctx, 12, RULE_attributeValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
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
		enterRule(_localctx, 14, RULE_jinja2Rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14L) != 0)) ) {
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
		enterRule(_localctx, 16, RULE_styleElement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(OPEN_STYLE);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33547989549056L) != 0)) {
				{
				{
				setState(113);
				cssStatement();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
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
		enterRule(_localctx, 18, RULE_cssStatement);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
			case IDENT:
			case OPEN_PARE:
			case CLOSE_PARE:
			case CLASS_SELECTOR:
			case ID_SELECTOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				cssRule();
				}
				break;
			case AT:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
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
		enterRule(_localctx, 20, RULE_atRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(AT);
			setState(126);
			match(IDENT);
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(127);
				selectorList();
				}
				break;
			}
			setState(130);
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
		enterRule(_localctx, 22, RULE_cssInnerBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COLON || _la==IDENT) {
				{
				{
				setState(132);
				cssDeclaration();
				}
				}
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(138);
			match(LBRACE);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33548526419968L) != 0)) {
				{
				setState(141);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(139);
					cssStatement();
					}
					break;
				case 2:
					{
					setState(140);
					cssDeclaration();
					}
					break;
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
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
		enterRule(_localctx, 24, RULE_cssDeclaration);
		int _la;
		try {
			int _alt;
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
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
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7679401525248L) != 0) );
				setState(155);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				match(IDENT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				match(COLON);
				setState(159);
				match(IDENT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				match(IDENT);
				setState(161);
				match(COLON);
				setState(163); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(162);
						cssValue();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(165); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(167);
				match(IDENT);
				setState(168);
				match(COLON);
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(169);
					cssValue();
					}
					}
					setState(172); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7679401525248L) != 0) );
				setState(180); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(174);
					match(COMMA);
					setState(176); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(175);
						cssValue();
						}
						}
						setState(178); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7679401525248L) != 0) );
					}
					}
					setState(182); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				setState(184);
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
		enterRule(_localctx, 26, RULE_cssValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7679401525248L) != 0)) ) {
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
		enterRule(_localctx, 28, RULE_cssRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			selectorList();
			setState(191);
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
		enterRule(_localctx, 30, RULE_selectorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			selector();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(194);
				match(COMMA);
				setState(195);
				selector();
				}
				}
				setState(200);
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
		enterRule(_localctx, 32, RULE_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33539399614464L) != 0)) ) {
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
		"\u0004\u0001,\u00cc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0003\u0000*\b\u0000\u0001\u0000\u0005\u0000-\b"+
		"\u0000\n\u0000\f\u00000\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0005"+
		"\u00015\b\u0001\n\u0001\f\u00018\t\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003E\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004J\b\u0004\n\u0004\f\u0004M\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004Q\b\u0004\n\u0004\f\u0004T\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004\\\b\u0004\n\u0004\f\u0004_\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004e\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005k\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0005\bs\b\b\n\b\f\bv\t\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0003\t|\b\t\u0001\n\u0001\n\u0001\n\u0003\n\u0081"+
		"\b\n\u0001\n\u0001\n\u0001\u000b\u0005\u000b\u0086\b\u000b\n\u000b\f\u000b"+
		"\u0089\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u008e\b"+
		"\u000b\n\u000b\f\u000b\u0091\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0004\f\u0098\b\f\u000b\f\f\f\u0099\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u00a4\b\f\u000b\f\f\f"+
		"\u00a5\u0001\f\u0001\f\u0001\f\u0004\f\u00ab\b\f\u000b\f\f\f\u00ac\u0001"+
		"\f\u0001\f\u0004\f\u00b1\b\f\u000b\f\f\f\u00b2\u0004\f\u00b5\b\f\u000b"+
		"\f\f\f\u00b6\u0001\f\u0001\f\u0003\f\u00bb\b\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00c5\b\u000f\n\u000f\f\u000f\u00c8\t\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0000\u0000\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0004\u0001\u0000\u0013\u0015"+
		"\u0001\u0000\u0001\u0003\u0002\u0000\"\')*\u0003\u0000  \'\'),\u00da\u0000"+
		"%\u0001\u0000\u0000\u0000\u00026\u0001\u0000\u0000\u0000\u0004;\u0001"+
		"\u0000\u0000\u0000\u0006D\u0001\u0000\u0000\u0000\bd\u0001\u0000\u0000"+
		"\u0000\nj\u0001\u0000\u0000\u0000\fl\u0001\u0000\u0000\u0000\u000en\u0001"+
		"\u0000\u0000\u0000\u0010p\u0001\u0000\u0000\u0000\u0012{\u0001\u0000\u0000"+
		"\u0000\u0014}\u0001\u0000\u0000\u0000\u0016\u0087\u0001\u0000\u0000\u0000"+
		"\u0018\u00ba\u0001\u0000\u0000\u0000\u001a\u00bc\u0001\u0000\u0000\u0000"+
		"\u001c\u00be\u0001\u0000\u0000\u0000\u001e\u00c1\u0001\u0000\u0000\u0000"+
		" \u00c9\u0001\u0000\u0000\u0000\"$\u0003\u0006\u0003\u0000#\"\u0001\u0000"+
		"\u0000\u0000$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001"+
		"\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000"+
		"(*\u0003\u0004\u0002\u0000)(\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000"+
		"\u0000*.\u0001\u0000\u0000\u0000+-\u0003\u0006\u0003\u0000,+\u0001\u0000"+
		"\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001"+
		"\u0000\u0000\u0000/1\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000"+
		"12\u0005\u0000\u0000\u00012\u0001\u0001\u0000\u0000\u000035\u0003\u0012"+
		"\t\u000043\u0001\u0000\u0000\u000058\u0001\u0000\u0000\u000064\u0001\u0000"+
		"\u0000\u000067\u0001\u0000\u0000\u000079\u0001\u0000\u0000\u000086\u0001"+
		"\u0000\u0000\u00009:\u0005\u0000\u0000\u0001:\u0003\u0001\u0000\u0000"+
		"\u0000;<\u0005\u0004\u0000\u0000<\u0005\u0001\u0000\u0000\u0000=E\u0003"+
		"\b\u0004\u0000>E\u0003\u0010\b\u0000?E\u0005\u0001\u0000\u0000@E\u0005"+
		"\u0002\u0000\u0000AE\u0005\f\u0000\u0000BE\u0005\n\u0000\u0000CE\u0005"+
		"\t\u0000\u0000D=\u0001\u0000\u0000\u0000D>\u0001\u0000\u0000\u0000D?\u0001"+
		"\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000DA\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000E\u0007\u0001\u0000"+
		"\u0000\u0000FG\u0005\u0007\u0000\u0000GK\u0005\u0011\u0000\u0000HJ\u0003"+
		"\n\u0005\u0000IH\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000"+
		"MK\u0001\u0000\u0000\u0000NR\u0005\u0018\u0000\u0000OQ\u0003\u0006\u0003"+
		"\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000UV\u0005\b\u0000\u0000VW\u0005\u0011\u0000\u0000We\u0005"+
		"\u0018\u0000\u0000XY\u0005\u0007\u0000\u0000Y]\u0005\u0011\u0000\u0000"+
		"Z\\\u0003\n\u0005\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000"+
		"\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0001\u0000"+
		"\u0000\u0000_]\u0001\u0000\u0000\u0000`e\u0005\u0017\u0000\u0000ab\u0005"+
		"\b\u0000\u0000bc\u0005\u0011\u0000\u0000ce\u0005\u0018\u0000\u0000dF\u0001"+
		"\u0000\u0000\u0000dX\u0001\u0000\u0000\u0000da\u0001\u0000\u0000\u0000"+
		"e\t\u0001\u0000\u0000\u0000fg\u0005\u0011\u0000\u0000gh\u0005\u0012\u0000"+
		"\u0000hk\u0003\f\u0006\u0000ik\u0005\u0011\u0000\u0000jf\u0001\u0000\u0000"+
		"\u0000ji\u0001\u0000\u0000\u0000k\u000b\u0001\u0000\u0000\u0000lm\u0007"+
		"\u0000\u0000\u0000m\r\u0001\u0000\u0000\u0000no\u0007\u0001\u0000\u0000"+
		"o\u000f\u0001\u0000\u0000\u0000pt\u0005\u0005\u0000\u0000qs\u0003\u0012"+
		"\t\u0000rq\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000"+
		"\u0000\u0000tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000\u0000vt\u0001"+
		"\u0000\u0000\u0000wx\u0005\u0006\u0000\u0000x\u0011\u0001\u0000\u0000"+
		"\u0000y|\u0003\u001c\u000e\u0000z|\u0003\u0014\n\u0000{y\u0001\u0000\u0000"+
		"\u0000{z\u0001\u0000\u0000\u0000|\u0013\u0001\u0000\u0000\u0000}~\u0005"+
		"!\u0000\u0000~\u0080\u0005\'\u0000\u0000\u007f\u0081\u0003\u001e\u000f"+
		"\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0003\u0016\u000b"+
		"\u0000\u0083\u0015\u0001\u0000\u0000\u0000\u0084\u0086\u0003\u0018\f\u0000"+
		"\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000"+
		"\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000"+
		"\u0088\u008a\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000"+
		"\u008a\u008f\u0005\u001b\u0000\u0000\u008b\u008e\u0003\u0012\t\u0000\u008c"+
		"\u008e\u0003\u0018\f\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008c"+
		"\u0001\u0000\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d"+
		"\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0092"+
		"\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0005\u001c\u0000\u0000\u0093\u0017\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0005\'\u0000\u0000\u0095\u0097\u0005\u001d\u0000\u0000\u0096\u0098\u0003"+
		"\u001a\r\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000"+
		"\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u001e"+
		"\u0000\u0000\u009c\u00bb\u0001\u0000\u0000\u0000\u009d\u00bb\u0005\'\u0000"+
		"\u0000\u009e\u009f\u0005\u001d\u0000\u0000\u009f\u00bb\u0005\'\u0000\u0000"+
		"\u00a0\u00a1\u0005\'\u0000\u0000\u00a1\u00a3\u0005\u001d\u0000\u0000\u00a2"+
		"\u00a4\u0003\u001a\r\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a6\u00bb\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0005\'\u0000\u0000\u00a8\u00aa\u0005\u001d\u0000\u0000\u00a9\u00ab\u0003"+
		"\u001a\r\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ad\u00b4\u0001\u0000\u0000\u0000\u00ae\u00b0\u0005\u001f"+
		"\u0000\u0000\u00af\u00b1\u0003\u001a\r\u0000\u00b0\u00af\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b4\u00ae\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u001e\u0000"+
		"\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u0094\u0001\u0000\u0000"+
		"\u0000\u00ba\u009d\u0001\u0000\u0000\u0000\u00ba\u009e\u0001\u0000\u0000"+
		"\u0000\u00ba\u00a0\u0001\u0000\u0000\u0000\u00ba\u00a7\u0001\u0000\u0000"+
		"\u0000\u00bb\u0019\u0001\u0000\u0000\u0000\u00bc\u00bd\u0007\u0002\u0000"+
		"\u0000\u00bd\u001b\u0001\u0000\u0000\u0000\u00be\u00bf\u0003\u001e\u000f"+
		"\u0000\u00bf\u00c0\u0003\u0016\u000b\u0000\u00c0\u001d\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c6\u0003 \u0010\u0000\u00c2\u00c3\u0005\u001f\u0000\u0000"+
		"\u00c3\u00c5\u0003 \u0010\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c7\u001f\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c9\u00ca\u0007\u0003\u0000\u0000\u00ca"+
		"!\u0001\u0000\u0000\u0000\u0017%).6DKR]djt{\u0080\u0087\u008d\u008f\u0099"+
		"\u00a5\u00ac\u00b2\u00b6\u00ba\u00c6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}