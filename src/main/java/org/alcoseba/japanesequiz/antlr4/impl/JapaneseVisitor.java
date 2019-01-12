package org.alcoseba.japanesequiz.antlr4.impl;

import org.alcoseba.japaneseparser.antlr4.JapaneseParserBaseListener;
import org.alcoseba.japaneseparser.antlr4.JapaneseParserParser.ParseContext;

public class JapaneseVisitor extends JapaneseParserBaseListener {

	@Override
	public void exitParse(ParseContext ctx) {
		super.exitParse(ctx);
	}

	@Override
	public void enterParse(ParseContext ctx) {
		System.out.println(ctx.getText());
		super.enterParse(ctx);
	}
}
