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
		CLOSE_PARE=42, CLASS_SELECTOR=43, ID_SELECTOR=44, FUNCTION=45;
	public static final int
		RULE_htmlDocument = 0, RULE_doctype = 1, RULE_element = 2, RULE_htmlElement = 3, 
		RULE_attribute = 4, RULE_attributeValue = 5, RULE_jinja2Rule = 6, RULE_cssFile = 7, 
		RULE_cssRule = 8, RULE_cssBlock = 9, RULE_cssDeclaration = 10, RULE_cssValueList = 11, 
		RULE_cssValue = 12, RULE_selectorList = 13, RULE_selector = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"htmlDocument", "doctype", "element", "htmlElement", "attribute", "attributeValue", 
			"jinja2Rule", "cssFile", "cssRule", "cssBlock", "cssDeclaration", "cssValueList", 
			"cssValue", "selectorList", "selector"
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
			"CLASS_SELECTOR", "ID_SELECTOR", "FUNCTION"
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
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(30);
					element();
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOCTYPE) {
				{
				setState(36);
				doctype();
				}
			}

			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6022L) != 0)) {
				{
				{
				setState(39);
				element();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
		enterRule(_localctx, 2, RULE_doctype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
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
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_TAG:
			case CLOSE_TAG:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				htmlElement();
				}
				break;
			case EXPRESSION:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(EXPRESSION);
				}
				break;
			case STATEMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(51);
				match(STATEMENT);
				}
				break;
			case LBRACE_HTML:
				enterOuterAlt(_localctx, 4);
				{
				setState(52);
				match(LBRACE_HTML);
				}
				break;
			case TEXT:
				enterOuterAlt(_localctx, 5);
				{
				setState(53);
				match(TEXT);
				}
				break;
			case ENTITY:
				enterOuterAlt(_localctx, 6);
				{
				setState(54);
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
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(OPEN_TAG);
				setState(58);
				match(TAG_NAME);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(59);
					attribute();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				match(TAG_CLOSE);
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(66);
						element();
						}
						} 
					}
					setState(71);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(72);
				match(CLOSE_TAG);
				setState(73);
				match(TAG_NAME);
				setState(74);
				match(TAG_CLOSE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(OPEN_TAG);
				setState(76);
				match(TAG_NAME);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TAG_NAME) {
					{
					{
					setState(77);
					attribute();
					}
					}
					setState(82);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(83);
				match(SELF_CLOSE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				match(CLOSE_TAG);
				setState(85);
				match(TAG_NAME);
				setState(86);
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
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(TAG_NAME);
				setState(90);
				match(EQUALS);
				setState(91);
				attributeValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
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
			setState(95);
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
		enterRule(_localctx, 12, RULE_jinja2Rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
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
	public static class CssFileContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ExampleParser.EOF, 0); }
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
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
		enterRule(_localctx, 14, RULE_cssFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 26942329847808L) != 0)) {
				{
				{
				setState(99);
				cssRule();
				}
				}
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(105);
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
	public static class CssRuleContext extends ParserRuleContext {
		public SelectorListContext selectorList() {
			return getRuleContext(SelectorListContext.class,0);
		}
		public CssBlockContext cssBlock() {
			return getRuleContext(CssBlockContext.class,0);
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
		enterRule(_localctx, 16, RULE_cssRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			selectorList();
			setState(108);
			cssBlock();
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
	public static class CssBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ExampleParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ExampleParser.RBRACE, 0); }
		public List<CssDeclarationContext> cssDeclaration() {
			return getRuleContexts(CssDeclarationContext.class);
		}
		public CssDeclarationContext cssDeclaration(int i) {
			return getRuleContext(CssDeclarationContext.class,i);
		}
		public CssBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterCssBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitCssBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitCssBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssBlockContext cssBlock() throws RecognitionException {
		CssBlockContext _localctx = new CssBlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cssBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(LBRACE);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(111);
				cssDeclaration();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
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
		public CssValueListContext cssValueList() {
			return getRuleContext(CssValueListContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(ExampleParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 20, RULE_cssDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(IDENT);
			setState(120);
			match(COLON);
			setState(121);
			cssValueList();
			setState(122);
			match(SEMICOLON);
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
	public static class CssValueListContext extends ParserRuleContext {
		public List<CssValueContext> cssValue() {
			return getRuleContexts(CssValueContext.class);
		}
		public CssValueContext cssValue(int i) {
			return getRuleContext(CssValueContext.class,i);
		}
		public CssValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).enterCssValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExampleParserListener ) ((ExampleParserListener)listener).exitCssValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExampleParserVisitor ) return ((ExampleParserVisitor<? extends T>)visitor).visitCssValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueListContext cssValueList() throws RecognitionException {
		CssValueListContext _localctx = new CssValueListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cssValueList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124);
				cssValue();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 36129264893952L) != 0) );
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
		public TerminalNode COLOR_HEX() { return getToken(ExampleParser.COLOR_HEX, 0); }
		public TerminalNode STRING() { return getToken(ExampleParser.STRING, 0); }
		public TerminalNode IDENT() { return getToken(ExampleParser.IDENT, 0); }
		public TerminalNode FUNCTION() { return getToken(ExampleParser.FUNCTION, 0); }
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
			setState(129);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 36129264893952L) != 0)) ) {
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
		enterRule(_localctx, 26, RULE_selectorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			selector();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(132);
				match(COMMA);
				setState(133);
				selector();
				}
				}
				setState(138);
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
		enterRule(_localctx, 28, RULE_selector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 26942329847808L) != 0)) ) {
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
		"\u0004\u0001-\u008e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0003\u0000&\b\u0000\u0001"+
		"\u0000\u0005\u0000)\b\u0000\n\u0000\f\u0000,\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u00028\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003=\b\u0003\n\u0003\f\u0003@\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003D\b\u0003\n\u0003\f\u0003G\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003O\b\u0003\n\u0003\f\u0003R\t\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003X\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004^\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0005\u0007e\b\u0007\n\u0007\f\u0007h\t"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0005\tq\b\t\n\t\f\tt\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0004\u000b~\b\u000b\u000b\u000b\f\u000b\u007f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r\u0087\b\r\n\r\f\r\u008a"+
		"\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000"+
		"\u0004\u0001\u0000\u0013\u0015\u0001\u0000\u0001\u0003\u0003\u0000\"$"+
		"&\'--\u0003\u0000  \'\'+,\u0090\u0000!\u0001\u0000\u0000\u0000\u0002/"+
		"\u0001\u0000\u0000\u0000\u00047\u0001\u0000\u0000\u0000\u0006W\u0001\u0000"+
		"\u0000\u0000\b]\u0001\u0000\u0000\u0000\n_\u0001\u0000\u0000\u0000\fa"+
		"\u0001\u0000\u0000\u0000\u000ef\u0001\u0000\u0000\u0000\u0010k\u0001\u0000"+
		"\u0000\u0000\u0012n\u0001\u0000\u0000\u0000\u0014w\u0001\u0000\u0000\u0000"+
		"\u0016}\u0001\u0000\u0000\u0000\u0018\u0081\u0001\u0000\u0000\u0000\u001a"+
		"\u0083\u0001\u0000\u0000\u0000\u001c\u008b\u0001\u0000\u0000\u0000\u001e"+
		" \u0003\u0004\u0002\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001"+
		"\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$&\u0003\u0002"+
		"\u0001\u0000%$\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&*\u0001"+
		"\u0000\u0000\u0000\')\u0003\u0004\u0002\u0000(\'\u0001\u0000\u0000\u0000"+
		"),\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-.\u0005\u0000"+
		"\u0000\u0001.\u0001\u0001\u0000\u0000\u0000/0\u0005\u0004\u0000\u0000"+
		"0\u0003\u0001\u0000\u0000\u000018\u0003\u0006\u0003\u000028\u0005\u0001"+
		"\u0000\u000038\u0005\u0002\u0000\u000048\u0005\f\u0000\u000058\u0005\n"+
		"\u0000\u000068\u0005\t\u0000\u000071\u0001\u0000\u0000\u000072\u0001\u0000"+
		"\u0000\u000073\u0001\u0000\u0000\u000074\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000076\u0001\u0000\u0000\u00008\u0005\u0001\u0000\u0000"+
		"\u00009:\u0005\u0007\u0000\u0000:>\u0005\u0011\u0000\u0000;=\u0003\b\u0004"+
		"\u0000<;\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000AE\u0005\u0018\u0000\u0000BD\u0003\u0004\u0002\u0000"+
		"CB\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GE\u0001\u0000"+
		"\u0000\u0000HI\u0005\b\u0000\u0000IJ\u0005\u0011\u0000\u0000JX\u0005\u0018"+
		"\u0000\u0000KL\u0005\u0007\u0000\u0000LP\u0005\u0011\u0000\u0000MO\u0003"+
		"\b\u0004\u0000NM\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000SX\u0005\u0017\u0000\u0000TU\u0005\b\u0000\u0000"+
		"UV\u0005\u0011\u0000\u0000VX\u0005\u0018\u0000\u0000W9\u0001\u0000\u0000"+
		"\u0000WK\u0001\u0000\u0000\u0000WT\u0001\u0000\u0000\u0000X\u0007\u0001"+
		"\u0000\u0000\u0000YZ\u0005\u0011\u0000\u0000Z[\u0005\u0012\u0000\u0000"+
		"[^\u0003\n\u0005\u0000\\^\u0005\u0011\u0000\u0000]Y\u0001\u0000\u0000"+
		"\u0000]\\\u0001\u0000\u0000\u0000^\t\u0001\u0000\u0000\u0000_`\u0007\u0000"+
		"\u0000\u0000`\u000b\u0001\u0000\u0000\u0000ab\u0007\u0001\u0000\u0000"+
		"b\r\u0001\u0000\u0000\u0000ce\u0003\u0010\b\u0000dc\u0001\u0000\u0000"+
		"\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000gi\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000ij\u0005"+
		"\u0000\u0000\u0001j\u000f\u0001\u0000\u0000\u0000kl\u0003\u001a\r\u0000"+
		"lm\u0003\u0012\t\u0000m\u0011\u0001\u0000\u0000\u0000nr\u0005\u001b\u0000"+
		"\u0000oq\u0003\u0014\n\u0000po\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000"+
		"\u0000\u0000tr\u0001\u0000\u0000\u0000uv\u0005\u001c\u0000\u0000v\u0013"+
		"\u0001\u0000\u0000\u0000wx\u0005\'\u0000\u0000xy\u0005\u001d\u0000\u0000"+
		"yz\u0003\u0016\u000b\u0000z{\u0005\u001e\u0000\u0000{\u0015\u0001\u0000"+
		"\u0000\u0000|~\u0003\u0018\f\u0000}|\u0001\u0000\u0000\u0000~\u007f\u0001"+
		"\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000"+
		"\u0000\u0000\u0080\u0017\u0001\u0000\u0000\u0000\u0081\u0082\u0007\u0002"+
		"\u0000\u0000\u0082\u0019\u0001\u0000\u0000\u0000\u0083\u0088\u0003\u001c"+
		"\u000e\u0000\u0084\u0085\u0005\u001f\u0000\u0000\u0085\u0087\u0003\u001c"+
		"\u000e\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u008a\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000"+
		"\u0000\u0000\u0089\u001b\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0007\u0003\u0000\u0000\u008c\u001d\u0001\u0000"+
		"\u0000\u0000\r!%*7>EPW]fr\u007f\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}