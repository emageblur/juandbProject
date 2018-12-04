// Generated from c:\Users\draems\Desktop\pyweb\app\juandb\gram.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, T__90=91, T__91=92, T__92=93, T__93=94, 
		T__94=95, T__95=96, ID=97, INT=98, WS=99;
	public static final int
		RULE_r = 0, RULE_select_statement = 1, RULE_delete_statement = 2, RULE_insert_statement = 3, 
		RULE_column = 4, RULE_columnlist = 5, RULE_table = 6, RULE_allChar = 7, 
		RULE_birthday = 8, RULE_time = 9, RULE_studentNo = 10, RULE_sem = 11, 
		RULE_inputValue = 12, RULE_operators = 13, RULE_operands = 14, RULE_condition = 15;
	public static final String[] ruleNames = {
		"r", "select_statement", "delete_statement", "insert_statement", "column", 
		"columnlist", "table", "allChar", "birthday", "time", "studentNo", "sem", 
		"inputValue", "operators", "operands", "condition"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'select'", "'from'", "'where'", "';'", "'delete from'", "'insert into'", 
		"'('", "'values ('", "', '", "');'", "'*'", "'studno'", "'studentname'", 
		"'birthday'", "'degree'", "'major'", "'unitsearned'", "'studno,'", "'studentname,'", 
		"'birthday,'", "'degree,'", "'major,'", "'unitsearned,'", "'description'", 
		"'action'", "'datefiled'", "'dateresolved'", "'description,'", "'action,'", 
		"'datefiled,'", "'dateresolved,'", "'cno'", "'ctitle'", "'cdesc'", "'noofunits'", 
		"'haslab'", "'semoffered'", "'cno,'", "'ctitle,'", "'cdesc,'", "'noofunits,'", 
		"'haslab,'", "'semoffered,'", "'semester'", "'acadyear'", "'section'", 
		"'time'", "'maxstud'", "'semester,'", "'acadyear,'", "'section,'", "'time,'", 
		"'maxstud,'", "'studno)'", "'studentname)'", "'birthday)'", "'degree)'", 
		"'major)'", "'unitsearned)'", "'action)'", "'datefile)'", "'dateresolved)'", 
		"'datefile,'", "'cno)'", "'ctitle)'", "'cdesc)'", "'noofunits)'", "'haslab)'", 
		"'semoffered)'", "'semester)'", "'acadyear)'", "'section)'", "'time)'", 
		"'maxstud)'", "'student'", "'studenthistory'", "'course'", "'courseoffering'", 
		"'studcourse'", "'1'", "'2'", "'-'", "'0'", "'3'", "':'", "'4'", "'5'", 
		"'1st'", "'2nd'", "'Sum'", "'<'", "'>'", "'='", "'!='", "'AND'", "'OR'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "ID", "INT", "WS"
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
	public String getGrammarFileName() { return "gram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public Select_statementContext select_statement() {
			return getRuleContext(Select_statementContext.class,0);
		}
		public Delete_statementContext delete_statement() {
			return getRuleContext(Delete_statementContext.class,0);
		}
		public Insert_statementContext insert_statement() {
			return getRuleContext(Insert_statementContext.class,0);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(32);
				select_statement();
				}
				break;
			case T__4:
				{
				setState(33);
				delete_statement();
				}
				break;
			case T__5:
				{
				setState(34);
				insert_statement();
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

	public static class Select_statementContext extends ParserRuleContext {
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public Select_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_statement; }
	}

	public final Select_statementContext select_statement() throws RecognitionException {
		Select_statementContext _localctx = new Select_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_select_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(T__0);
			setState(38);
			column();
			setState(39);
			match(T__1);
			setState(40);
			table();
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(41);
				match(T__2);
				setState(42);
				condition();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(T__3);
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

	public static class Delete_statementContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public Delete_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_statement; }
	}

	public final Delete_statementContext delete_statement() throws RecognitionException {
		Delete_statementContext _localctx = new Delete_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_delete_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__4);
			setState(51);
			table();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(52);
				match(T__2);
				setState(53);
				condition();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(T__3);
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

	public static class Insert_statementContext extends ParserRuleContext {
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
		}
		public List<InputValueContext> inputValue() {
			return getRuleContexts(InputValueContext.class);
		}
		public InputValueContext inputValue(int i) {
			return getRuleContext(InputValueContext.class,i);
		}
		public List<ColumnlistContext> columnlist() {
			return getRuleContexts(ColumnlistContext.class);
		}
		public ColumnlistContext columnlist(int i) {
			return getRuleContext(ColumnlistContext.class,i);
		}
		public Insert_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_statement; }
	}

	public final Insert_statementContext insert_statement() throws RecognitionException {
		Insert_statementContext _localctx = new Insert_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_insert_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__5);
			setState(62);
			table();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(63);
				match(T__6);
				setState(64);
				columnlist();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(T__7);
			{
			setState(71);
			inputValue();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(72);
				match(T__8);
				setState(73);
				inputValue();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(79);
			match(T__9);
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

	public static class ColumnContext extends ParserRuleContext {
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				setState(81);
				match(T__10);
				}
				break;
			case T__11:
				{
				setState(82);
				match(T__11);
				}
				break;
			case T__12:
				{
				setState(83);
				match(T__12);
				}
				break;
			case T__13:
				{
				setState(84);
				match(T__13);
				}
				break;
			case T__14:
				{
				setState(85);
				match(T__14);
				}
				break;
			case T__15:
				{
				setState(86);
				match(T__15);
				}
				break;
			case T__16:
				{
				setState(87);
				match(T__16);
				}
				break;
			case T__17:
				{
				setState(88);
				match(T__17);
				setState(89);
				column();
				}
				break;
			case T__18:
				{
				setState(90);
				match(T__18);
				setState(91);
				column();
				}
				break;
			case T__19:
				{
				setState(92);
				match(T__19);
				setState(93);
				column();
				}
				break;
			case T__20:
				{
				setState(94);
				match(T__20);
				setState(95);
				column();
				}
				break;
			case T__21:
				{
				setState(96);
				match(T__21);
				setState(97);
				column();
				}
				break;
			case T__22:
				{
				setState(98);
				match(T__22);
				setState(99);
				column();
				}
				break;
			case T__23:
				{
				setState(100);
				match(T__23);
				}
				break;
			case T__24:
				{
				setState(101);
				match(T__24);
				}
				break;
			case T__25:
				{
				setState(102);
				match(T__25);
				}
				break;
			case T__26:
				{
				setState(103);
				match(T__26);
				}
				break;
			case T__27:
				{
				setState(104);
				match(T__27);
				setState(105);
				column();
				}
				break;
			case T__28:
				{
				setState(106);
				match(T__28);
				setState(107);
				column();
				}
				break;
			case T__29:
				{
				setState(108);
				match(T__29);
				setState(109);
				column();
				}
				break;
			case T__30:
				{
				setState(110);
				match(T__30);
				setState(111);
				column();
				}
				break;
			case T__31:
				{
				setState(112);
				match(T__31);
				}
				break;
			case T__32:
				{
				setState(113);
				match(T__32);
				}
				break;
			case T__33:
				{
				setState(114);
				match(T__33);
				}
				break;
			case T__34:
				{
				setState(115);
				match(T__34);
				}
				break;
			case T__35:
				{
				setState(116);
				match(T__35);
				}
				break;
			case T__36:
				{
				setState(117);
				match(T__36);
				}
				break;
			case T__37:
				{
				setState(118);
				match(T__37);
				setState(119);
				column();
				}
				break;
			case T__38:
				{
				setState(120);
				match(T__38);
				setState(121);
				column();
				}
				break;
			case T__39:
				{
				setState(122);
				match(T__39);
				setState(123);
				column();
				}
				break;
			case T__40:
				{
				setState(124);
				match(T__40);
				setState(125);
				column();
				}
				break;
			case T__41:
				{
				setState(126);
				match(T__41);
				setState(127);
				column();
				}
				break;
			case T__42:
				{
				setState(128);
				match(T__42);
				setState(129);
				column();
				}
				break;
			case T__43:
				{
				setState(130);
				match(T__43);
				}
				break;
			case T__44:
				{
				setState(131);
				match(T__44);
				}
				break;
			case T__45:
				{
				setState(132);
				match(T__45);
				}
				break;
			case T__46:
				{
				setState(133);
				match(T__46);
				}
				break;
			case T__47:
				{
				setState(134);
				match(T__47);
				}
				break;
			case T__48:
				{
				setState(135);
				match(T__48);
				setState(136);
				column();
				}
				break;
			case T__49:
				{
				setState(137);
				match(T__49);
				setState(138);
				column();
				}
				break;
			case T__50:
				{
				setState(139);
				match(T__50);
				setState(140);
				column();
				}
				break;
			case T__51:
				{
				setState(141);
				match(T__51);
				setState(142);
				column();
				}
				break;
			case T__52:
				{
				setState(143);
				match(T__52);
				setState(144);
				column();
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

	public static class ColumnlistContext extends ParserRuleContext {
		public ColumnlistContext columnlist() {
			return getRuleContext(ColumnlistContext.class,0);
		}
		public ColumnlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnlist; }
	}

	public final ColumnlistContext columnlist() throws RecognitionException {
		ColumnlistContext _localctx = new ColumnlistContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_columnlist);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__53:
				{
				setState(147);
				match(T__53);
				}
				break;
			case T__54:
				{
				setState(148);
				match(T__54);
				}
				break;
			case T__55:
				{
				setState(149);
				match(T__55);
				}
				break;
			case T__56:
				{
				setState(150);
				match(T__56);
				}
				break;
			case T__57:
				{
				setState(151);
				match(T__57);
				}
				break;
			case T__58:
				{
				setState(152);
				match(T__58);
				}
				break;
			case T__17:
				{
				setState(153);
				match(T__17);
				setState(154);
				columnlist();
				}
				break;
			case T__18:
				{
				setState(155);
				match(T__18);
				setState(156);
				columnlist();
				}
				break;
			case T__19:
				{
				setState(157);
				match(T__19);
				setState(158);
				columnlist();
				}
				break;
			case T__20:
				{
				setState(159);
				match(T__20);
				setState(160);
				columnlist();
				}
				break;
			case T__21:
				{
				setState(161);
				match(T__21);
				setState(162);
				columnlist();
				}
				break;
			case T__22:
				{
				setState(163);
				match(T__22);
				setState(164);
				columnlist();
				}
				break;
			case T__23:
				{
				setState(165);
				match(T__23);
				}
				break;
			case T__59:
				{
				setState(166);
				match(T__59);
				}
				break;
			case T__60:
				{
				setState(167);
				match(T__60);
				}
				break;
			case T__61:
				{
				setState(168);
				match(T__61);
				}
				break;
			case T__27:
				{
				setState(169);
				match(T__27);
				setState(170);
				columnlist();
				}
				break;
			case T__28:
				{
				setState(171);
				match(T__28);
				setState(172);
				columnlist();
				}
				break;
			case T__62:
				{
				setState(173);
				match(T__62);
				setState(174);
				columnlist();
				}
				break;
			case T__30:
				{
				setState(175);
				match(T__30);
				setState(176);
				columnlist();
				}
				break;
			case T__63:
				{
				setState(177);
				match(T__63);
				}
				break;
			case T__64:
				{
				setState(178);
				match(T__64);
				}
				break;
			case T__65:
				{
				setState(179);
				match(T__65);
				}
				break;
			case T__66:
				{
				setState(180);
				match(T__66);
				}
				break;
			case T__67:
				{
				setState(181);
				match(T__67);
				}
				break;
			case T__68:
				{
				setState(182);
				match(T__68);
				}
				break;
			case T__37:
				{
				setState(183);
				match(T__37);
				setState(184);
				columnlist();
				}
				break;
			case T__38:
				{
				setState(185);
				match(T__38);
				setState(186);
				columnlist();
				}
				break;
			case T__39:
				{
				setState(187);
				match(T__39);
				setState(188);
				columnlist();
				}
				break;
			case T__40:
				{
				setState(189);
				match(T__40);
				setState(190);
				columnlist();
				}
				break;
			case T__41:
				{
				setState(191);
				match(T__41);
				setState(192);
				columnlist();
				}
				break;
			case T__42:
				{
				setState(193);
				match(T__42);
				setState(194);
				columnlist();
				}
				break;
			case T__69:
				{
				setState(195);
				match(T__69);
				}
				break;
			case T__70:
				{
				setState(196);
				match(T__70);
				}
				break;
			case T__71:
				{
				setState(197);
				match(T__71);
				}
				break;
			case T__72:
				{
				setState(198);
				match(T__72);
				}
				break;
			case T__73:
				{
				setState(199);
				match(T__73);
				}
				break;
			case T__48:
				{
				setState(200);
				match(T__48);
				setState(201);
				columnlist();
				}
				break;
			case T__49:
				{
				setState(202);
				match(T__49);
				setState(203);
				columnlist();
				}
				break;
			case T__50:
				{
				setState(204);
				match(T__50);
				setState(205);
				columnlist();
				}
				break;
			case T__51:
				{
				setState(206);
				match(T__51);
				setState(207);
				columnlist();
				}
				break;
			case T__52:
				{
				setState(208);
				match(T__52);
				setState(209);
				columnlist();
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

	public static class TableContext extends ParserRuleContext {
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_table);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !(((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__74 - 75)) | (1L << (T__75 - 75)) | (1L << (T__76 - 75)) | (1L << (T__77 - 75)) | (1L << (T__78 - 75)))) != 0)) ) {
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

	public static class AllCharContext extends ParserRuleContext {
		public AllCharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allChar; }
	}

	public final AllCharContext allChar() throws RecognitionException {
		AllCharContext _localctx = new AllCharContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_allChar);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(214);
					matchWildcard();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(217); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class BirthdayContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(gramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(gramParser.INT, i);
		}
		public BirthdayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_birthday; }
	}

	public final BirthdayContext birthday() throws RecognitionException {
		BirthdayContext _localctx = new BirthdayContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_birthday);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_la = _input.LA(1);
			if ( !(_la==T__79 || _la==T__80) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(220);
			match(INT);
			setState(221);
			match(INT);
			setState(222);
			match(INT);
			setState(223);
			match(T__81);
			setState(224);
			_la = _input.LA(1);
			if ( !(_la==T__79 || _la==T__82) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(225);
			match(INT);
			setState(226);
			match(T__81);
			setState(227);
			_la = _input.LA(1);
			if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__82 - 80)) | (1L << (T__83 - 80)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(228);
			match(INT);
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

	public static class TimeContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(gramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(gramParser.INT, i);
		}
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_time);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_la = _input.LA(1);
			if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__82 - 80)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(231);
			match(INT);
			setState(232);
			match(T__84);
			setState(233);
			_la = _input.LA(1);
			if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (T__79 - 80)) | (1L << (T__80 - 80)) | (1L << (T__82 - 80)) | (1L << (T__83 - 80)) | (1L << (T__85 - 80)) | (1L << (T__86 - 80)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(234);
			match(INT);
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

	public static class StudentNoContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(gramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(gramParser.INT, i);
		}
		public StudentNoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_studentNo; }
	}

	public final StudentNoContext studentNo() throws RecognitionException {
		StudentNoContext _localctx = new StudentNoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_studentNo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( !(_la==T__79 || _la==T__80) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(237);
			match(INT);
			setState(238);
			match(INT);
			setState(239);
			match(INT);
			setState(240);
			match(T__81);
			setState(241);
			match(INT);
			setState(242);
			match(INT);
			setState(243);
			match(INT);
			setState(244);
			match(INT);
			setState(245);
			match(INT);
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

	public static class SemContext extends ParserRuleContext {
		public SemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sem; }
	}

	public final SemContext sem() throws RecognitionException {
		SemContext _localctx = new SemContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_la = _input.LA(1);
			if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & ((1L << (T__87 - 88)) | (1L << (T__88 - 88)) | (1L << (T__89 - 88)))) != 0)) ) {
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

	public static class InputValueContext extends ParserRuleContext {
		public AllCharContext allChar() {
			return getRuleContext(AllCharContext.class,0);
		}
		public BirthdayContext birthday() {
			return getRuleContext(BirthdayContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public StudentNoContext studentNo() {
			return getRuleContext(StudentNoContext.class,0);
		}
		public SemContext sem() {
			return getRuleContext(SemContext.class,0);
		}
		public InputValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputValue; }
	}

	public final InputValueContext inputValue() throws RecognitionException {
		InputValueContext _localctx = new InputValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_inputValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(249);
				allChar();
				}
				break;
			case 2:
				{
				setState(250);
				birthday();
				}
				break;
			case 3:
				{
				setState(251);
				time();
				}
				break;
			case 4:
				{
				setState(252);
				studentNo();
				}
				break;
			case 5:
				{
				setState(253);
				sem();
				}
				break;
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

	public static class OperatorsContext extends ParserRuleContext {
		public OperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operators; }
	}

	public final OperatorsContext operators() throws RecognitionException {
		OperatorsContext _localctx = new OperatorsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_operators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_la = _input.LA(1);
			if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & ((1L << (T__90 - 91)) | (1L << (T__91 - 91)) | (1L << (T__92 - 91)) | (1L << (T__93 - 91)))) != 0)) ) {
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

	public static class OperandsContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public OperandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operands; }
	}

	public final OperandsContext operands() throws RecognitionException {
		OperandsContext _localctx = new OperandsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_operands);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__94:
				{
				setState(258);
				match(T__94);
				setState(259);
				condition();
				}
				break;
			case T__95:
				{
				setState(260);
				match(T__95);
				setState(261);
				condition();
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

	public static class ConditionContext extends ParserRuleContext {
		public ColumnContext column() {
			return getRuleContext(ColumnContext.class,0);
		}
		public OperatorsContext operators() {
			return getRuleContext(OperatorsContext.class,0);
		}
		public InputValueContext inputValue() {
			return getRuleContext(InputValueContext.class,0);
		}
		public List<OperandsContext> operands() {
			return getRuleContexts(OperandsContext.class);
		}
		public OperandsContext operands(int i) {
			return getRuleContext(OperandsContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_condition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			column();
			setState(265);
			operators();
			setState(266);
			inputValue();
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(267);
					operands();
					}
					} 
				}
				setState(272);
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
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3e\u0114\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\5\2&\n\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5D"+
		"\n\5\f\5\16\5G\13\5\3\5\3\5\3\5\3\5\7\5M\n\5\f\5\16\5P\13\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0094\n\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00d5\n\7\3\b\3\b\3\t\6\t\u00da\n\t"+
		"\r\t\16\t\u00db\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\5\16\u0101\n\16\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\5\20\u0109\n\20\3\21\3\21\3\21\3\21\7\21\u010f\n\21\f\21\16\21\u0112"+
		"\13\21\3\21\3\u00db\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\n\3"+
		"\2MQ\3\2RS\4\2RRUU\4\2RSUV\4\2RSUU\5\2RSUVXY\3\2Z\\\3\2]`\2\u0163\2%\3"+
		"\2\2\2\4\'\3\2\2\2\6\64\3\2\2\2\b?\3\2\2\2\n\u0093\3\2\2\2\f\u00d4\3\2"+
		"\2\2\16\u00d6\3\2\2\2\20\u00d9\3\2\2\2\22\u00dd\3\2\2\2\24\u00e8\3\2\2"+
		"\2\26\u00ee\3\2\2\2\30\u00f9\3\2\2\2\32\u0100\3\2\2\2\34\u0102\3\2\2\2"+
		"\36\u0108\3\2\2\2 \u010a\3\2\2\2\"&\5\4\3\2#&\5\6\4\2$&\5\b\5\2%\"\3\2"+
		"\2\2%#\3\2\2\2%$\3\2\2\2&\3\3\2\2\2\'(\7\3\2\2()\5\n\6\2)*\7\4\2\2*/\5"+
		"\16\b\2+,\7\5\2\2,.\5 \21\2-+\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2"+
		"\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\6\2\2\63\5\3\2\2\2\64\65\7\7\2\2"+
		"\65:\5\16\b\2\66\67\7\5\2\2\679\5 \21\28\66\3\2\2\29<\3\2\2\2:8\3\2\2"+
		"\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7\6\2\2>\7\3\2\2\2?@\7\b\2\2@E\5\16"+
		"\b\2AB\7\t\2\2BD\5\f\7\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2"+
		"\2\2GE\3\2\2\2HI\7\n\2\2IN\5\32\16\2JK\7\13\2\2KM\5\32\16\2LJ\3\2\2\2"+
		"MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\f\2\2R\t\3\2\2"+
		"\2S\u0094\7\r\2\2T\u0094\7\16\2\2U\u0094\7\17\2\2V\u0094\7\20\2\2W\u0094"+
		"\7\21\2\2X\u0094\7\22\2\2Y\u0094\7\23\2\2Z[\7\24\2\2[\u0094\5\n\6\2\\"+
		"]\7\25\2\2]\u0094\5\n\6\2^_\7\26\2\2_\u0094\5\n\6\2`a\7\27\2\2a\u0094"+
		"\5\n\6\2bc\7\30\2\2c\u0094\5\n\6\2de\7\31\2\2e\u0094\5\n\6\2f\u0094\7"+
		"\32\2\2g\u0094\7\33\2\2h\u0094\7\34\2\2i\u0094\7\35\2\2jk\7\36\2\2k\u0094"+
		"\5\n\6\2lm\7\37\2\2m\u0094\5\n\6\2no\7 \2\2o\u0094\5\n\6\2pq\7!\2\2q\u0094"+
		"\5\n\6\2r\u0094\7\"\2\2s\u0094\7#\2\2t\u0094\7$\2\2u\u0094\7%\2\2v\u0094"+
		"\7&\2\2w\u0094\7\'\2\2xy\7(\2\2y\u0094\5\n\6\2z{\7)\2\2{\u0094\5\n\6\2"+
		"|}\7*\2\2}\u0094\5\n\6\2~\177\7+\2\2\177\u0094\5\n\6\2\u0080\u0081\7,"+
		"\2\2\u0081\u0094\5\n\6\2\u0082\u0083\7-\2\2\u0083\u0094\5\n\6\2\u0084"+
		"\u0094\7.\2\2\u0085\u0094\7/\2\2\u0086\u0094\7\60\2\2\u0087\u0094\7\61"+
		"\2\2\u0088\u0094\7\62\2\2\u0089\u008a\7\63\2\2\u008a\u0094\5\n\6\2\u008b"+
		"\u008c\7\64\2\2\u008c\u0094\5\n\6\2\u008d\u008e\7\65\2\2\u008e\u0094\5"+
		"\n\6\2\u008f\u0090\7\66\2\2\u0090\u0094\5\n\6\2\u0091\u0092\7\67\2\2\u0092"+
		"\u0094\5\n\6\2\u0093S\3\2\2\2\u0093T\3\2\2\2\u0093U\3\2\2\2\u0093V\3\2"+
		"\2\2\u0093W\3\2\2\2\u0093X\3\2\2\2\u0093Y\3\2\2\2\u0093Z\3\2\2\2\u0093"+
		"\\\3\2\2\2\u0093^\3\2\2\2\u0093`\3\2\2\2\u0093b\3\2\2\2\u0093d\3\2\2\2"+
		"\u0093f\3\2\2\2\u0093g\3\2\2\2\u0093h\3\2\2\2\u0093i\3\2\2\2\u0093j\3"+
		"\2\2\2\u0093l\3\2\2\2\u0093n\3\2\2\2\u0093p\3\2\2\2\u0093r\3\2\2\2\u0093"+
		"s\3\2\2\2\u0093t\3\2\2\2\u0093u\3\2\2\2\u0093v\3\2\2\2\u0093w\3\2\2\2"+
		"\u0093x\3\2\2\2\u0093z\3\2\2\2\u0093|\3\2\2\2\u0093~\3\2\2\2\u0093\u0080"+
		"\3\2\2\2\u0093\u0082\3\2\2\2\u0093\u0084\3\2\2\2\u0093\u0085\3\2\2\2\u0093"+
		"\u0086\3\2\2\2\u0093\u0087\3\2\2\2\u0093\u0088\3\2\2\2\u0093\u0089\3\2"+
		"\2\2\u0093\u008b\3\2\2\2\u0093\u008d\3\2\2\2\u0093\u008f\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0094\13\3\2\2\2\u0095\u00d5\78\2\2\u0096\u00d5\79\2\2"+
		"\u0097\u00d5\7:\2\2\u0098\u00d5\7;\2\2\u0099\u00d5\7<\2\2\u009a\u00d5"+
		"\7=\2\2\u009b\u009c\7\24\2\2\u009c\u00d5\5\f\7\2\u009d\u009e\7\25\2\2"+
		"\u009e\u00d5\5\f\7\2\u009f\u00a0\7\26\2\2\u00a0\u00d5\5\f\7\2\u00a1\u00a2"+
		"\7\27\2\2\u00a2\u00d5\5\f\7\2\u00a3\u00a4\7\30\2\2\u00a4\u00d5\5\f\7\2"+
		"\u00a5\u00a6\7\31\2\2\u00a6\u00d5\5\f\7\2\u00a7\u00d5\7\32\2\2\u00a8\u00d5"+
		"\7>\2\2\u00a9\u00d5\7?\2\2\u00aa\u00d5\7@\2\2\u00ab\u00ac\7\36\2\2\u00ac"+
		"\u00d5\5\f\7\2\u00ad\u00ae\7\37\2\2\u00ae\u00d5\5\f\7\2\u00af\u00b0\7"+
		"A\2\2\u00b0\u00d5\5\f\7\2\u00b1\u00b2\7!\2\2\u00b2\u00d5\5\f\7\2\u00b3"+
		"\u00d5\7B\2\2\u00b4\u00d5\7C\2\2\u00b5\u00d5\7D\2\2\u00b6\u00d5\7E\2\2"+
		"\u00b7\u00d5\7F\2\2\u00b8\u00d5\7G\2\2\u00b9\u00ba\7(\2\2\u00ba\u00d5"+
		"\5\f\7\2\u00bb\u00bc\7)\2\2\u00bc\u00d5\5\f\7\2\u00bd\u00be\7*\2\2\u00be"+
		"\u00d5\5\f\7\2\u00bf\u00c0\7+\2\2\u00c0\u00d5\5\f\7\2\u00c1\u00c2\7,\2"+
		"\2\u00c2\u00d5\5\f\7\2\u00c3\u00c4\7-\2\2\u00c4\u00d5\5\f\7\2\u00c5\u00d5"+
		"\7H\2\2\u00c6\u00d5\7I\2\2\u00c7\u00d5\7J\2\2\u00c8\u00d5\7K\2\2\u00c9"+
		"\u00d5\7L\2\2\u00ca\u00cb\7\63\2\2\u00cb\u00d5\5\f\7\2\u00cc\u00cd\7\64"+
		"\2\2\u00cd\u00d5\5\f\7\2\u00ce\u00cf\7\65\2\2\u00cf\u00d5\5\f\7\2\u00d0"+
		"\u00d1\7\66\2\2\u00d1\u00d5\5\f\7\2\u00d2\u00d3\7\67\2\2\u00d3\u00d5\5"+
		"\f\7\2\u00d4\u0095\3\2\2\2\u00d4\u0096\3\2\2\2\u00d4\u0097\3\2\2\2\u00d4"+
		"\u0098\3\2\2\2\u00d4\u0099\3\2\2\2\u00d4\u009a\3\2\2\2\u00d4\u009b\3\2"+
		"\2\2\u00d4\u009d\3\2\2\2\u00d4\u009f\3\2\2\2\u00d4\u00a1\3\2\2\2\u00d4"+
		"\u00a3\3\2\2\2\u00d4\u00a5\3\2\2\2\u00d4\u00a7\3\2\2\2\u00d4\u00a8\3\2"+
		"\2\2\u00d4\u00a9\3\2\2\2\u00d4\u00aa\3\2\2\2\u00d4\u00ab\3\2\2\2\u00d4"+
		"\u00ad\3\2\2\2\u00d4\u00af\3\2\2\2\u00d4\u00b1\3\2\2\2\u00d4\u00b3\3\2"+
		"\2\2\u00d4\u00b4\3\2\2\2\u00d4\u00b5\3\2\2\2\u00d4\u00b6\3\2\2\2\u00d4"+
		"\u00b7\3\2\2\2\u00d4\u00b8\3\2\2\2\u00d4\u00b9\3\2\2\2\u00d4\u00bb\3\2"+
		"\2\2\u00d4\u00bd\3\2\2\2\u00d4\u00bf\3\2\2\2\u00d4\u00c1\3\2\2\2\u00d4"+
		"\u00c3\3\2\2\2\u00d4\u00c5\3\2\2\2\u00d4\u00c6\3\2\2\2\u00d4\u00c7\3\2"+
		"\2\2\u00d4\u00c8\3\2\2\2\u00d4\u00c9\3\2\2\2\u00d4\u00ca\3\2\2\2\u00d4"+
		"\u00cc\3\2\2\2\u00d4\u00ce\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d5\r\3\2\2\2\u00d6\u00d7\t\2\2\2\u00d7\17\3\2\2\2\u00d8\u00da"+
		"\13\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2"+
		"\u00db\u00d9\3\2\2\2\u00dc\21\3\2\2\2\u00dd\u00de\t\3\2\2\u00de\u00df"+
		"\7d\2\2\u00df\u00e0\7d\2\2\u00e0\u00e1\7d\2\2\u00e1\u00e2\7T\2\2\u00e2"+
		"\u00e3\t\4\2\2\u00e3\u00e4\7d\2\2\u00e4\u00e5\7T\2\2\u00e5\u00e6\t\5\2"+
		"\2\u00e6\u00e7\7d\2\2\u00e7\23\3\2\2\2\u00e8\u00e9\t\6\2\2\u00e9\u00ea"+
		"\7d\2\2\u00ea\u00eb\7W\2\2\u00eb\u00ec\t\7\2\2\u00ec\u00ed\7d\2\2\u00ed"+
		"\25\3\2\2\2\u00ee\u00ef\t\3\2\2\u00ef\u00f0\7d\2\2\u00f0\u00f1\7d\2\2"+
		"\u00f1\u00f2\7d\2\2\u00f2\u00f3\7T\2\2\u00f3\u00f4\7d\2\2\u00f4\u00f5"+
		"\7d\2\2\u00f5\u00f6\7d\2\2\u00f6\u00f7\7d\2\2\u00f7\u00f8\7d\2\2\u00f8"+
		"\27\3\2\2\2\u00f9\u00fa\t\b\2\2\u00fa\31\3\2\2\2\u00fb\u0101\5\20\t\2"+
		"\u00fc\u0101\5\22\n\2\u00fd\u0101\5\24\13\2\u00fe\u0101\5\26\f\2\u00ff"+
		"\u0101\5\30\r\2\u0100\u00fb\3\2\2\2\u0100\u00fc\3\2\2\2\u0100\u00fd\3"+
		"\2\2\2\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101\33\3\2\2\2\u0102"+
		"\u0103\t\t\2\2\u0103\35\3\2\2\2\u0104\u0105\7a\2\2\u0105\u0109\5 \21\2"+
		"\u0106\u0107\7b\2\2\u0107\u0109\5 \21\2\u0108\u0104\3\2\2\2\u0108\u0106"+
		"\3\2\2\2\u0109\37\3\2\2\2\u010a\u010b\5\n\6\2\u010b\u010c\5\34\17\2\u010c"+
		"\u0110\5\32\16\2\u010d\u010f\5\36\20\2\u010e\u010d\3\2\2\2\u010f\u0112"+
		"\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111!\3\2\2\2\u0112"+
		"\u0110\3\2\2\2\r%/:EN\u0093\u00d4\u00db\u0100\u0108\u0110";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}