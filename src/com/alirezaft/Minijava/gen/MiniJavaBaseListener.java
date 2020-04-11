// Generated from E:/Projects/CompilerProject-Phase1/grammar\MiniJava.g4 by ANTLR 4.8
package com.alirezaft.Minijava.gen;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.alirezaft.Minijava.gen.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * This class provides an empty implementation of {@link MiniJavaListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class MiniJavaBaseListener implements MiniJavaListener {
	private int IndentLevel = 0;
	private File Output;
	private FileWriter Writer;
	private StringBuilder sbuilder;

	public MiniJavaBaseListener(){
		try{
			Output = new File("Output.txt");
			Output.createNewFile();
			Writer =  new FileWriter(Output);
		}catch(IOException e){
			e.printStackTrace();
		}
		sbuilder = new StringBuilder();
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterProgram(MiniJavaParser.ProgramContext ctx) {
		IndentLevel++;
		sbuilder.append("program start{\n");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProgram(MiniJavaParser.ProgramContext ctx) {
		IndentLevel--;
		sbuilder.append("}");
		System.out.println(sbuilder.toString());
		try {
//			Writer.append(sbuilder.toString());
			Writer.write(sbuilder.toString());
			Writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterImportClass(MiniJavaParser.ImportClassContext ctx) {
		writeIndent();
		sbuilder.append("import class: " + ctx.Identifier() + "\n");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitImportClass(MiniJavaParser.ImportClassContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMainClass(MiniJavaParser.MainClassContext ctx) {
		writeIndent();
		sbuilder.append("main class: " + ctx.Identifier(0) + "{\n");
		IndentLevel++;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMainClass(MiniJavaParser.MainClassContext ctx) {
		IndentLevel--;
		writeIndent();
		sbuilder.append("}\n");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
		writeIndent();
		IndentLevel++;
		sbuilder.append("class: " + ctx.Identifier(0));
		if(ctx.getText().contains("implements") || ctx.getText().contains("extends")){
			sbuilder.append("/ class parents: ");
			if(ctx.getText().contains("extends")){
				sbuilder.append(ctx.Identifier(1));
			}
			if(ctx.getText().contains("implements")){
				for(int i = ctx.getText().contains("extends")? 5 : 3; i < ctx.getChildCount(); i++){

					if(i == (ctx.getText().contains("extends")? 5 : 3)){
						sbuilder.append(ctx.getChild(i) + ", ");
					}else if(ctx.getChild(i).getPayload() instanceof Token && !((Token)ctx.getChild(i).getPayload()).getText().equals("{")){
						sbuilder.append(", " + ctx.getChild(i));
					}else{
						sbuilder.append("{\n");
						System.out.println("WAH!");
//						IndentLevel++;
						break;
					}
				}
			}
		}

//		for(int i = 2; i )
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
		IndentLevel--;
		writeIndent();
		sbuilder.append("}\n");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInterfaceDeclaration(MiniJavaParser.InterfaceDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInterfaceDeclaration(MiniJavaParser.InterfaceDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInterfaceMethodDeclaration(MiniJavaParser.InterfaceMethodDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInterfaceMethodDeclaration(MiniJavaParser.InterfaceMethodDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFieldDeclaration(MiniJavaParser.FieldDeclarationContext ctx) {
		writeIndent();
		sbuilder.append("field: " + ctx.Identifier() + "/ type=");
		String type = ctx.type().Identifier() == null ? ctx.type().javaType().getText() : ctx.type().Identifier().getText();
		System.out.println(type);
		sbuilder.append(type);
		if(ctx.type().LSB() != null){
			sbuilder.append("[]");
		}

		sbuilder.append("/ access modifier=" + (ctx.accessModifier() == null ? "public" : ctx.accessModifier()));
		sbuilder.append("\n");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFieldDeclaration(MiniJavaParser.FieldDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLocalDeclaration(MiniJavaParser.LocalDeclarationContext ctx) {
		writeIndent();
		sbuilder.append("local var: " + ctx.Identifier() + "/ " + "type="
				+  (ctx.type().Identifier() == null ? ctx.type().javaType().getText() : ctx.type().Identifier().getText())  + "\n");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLocalDeclaration(MiniJavaParser.LocalDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
		writeIndent();
		IndentLevel++;
		sbuilder.append("class method: " + ctx.Identifier() + "/return type=");
		if(ctx.returnType().type() == null){
			sbuilder.append("void");
		}else{
			sbuilder.append(ctx.returnType().type().Identifier() == null ? ctx.returnType().type().javaType().getText()
					: ctx.returnType().type().Identifier());
		}
		sbuilder.append("/ access modifier=" + ctx.accessModifier().getText() + "{\n");
//		writeIndent();
		if(ctx.parameterList() != null){
			IndentLevel++;
			writeIndent();
			sbuilder.append("parameters list=[");
			for(int i = 0; ctx.parameterList().parameter(i) != null; i++){
				sbuilder.append(ctx.parameterList().parameter(i).type().getText() + " "
						+ ctx.parameterList().parameter(i).Identifier() + ", ");
			}
			sbuilder.append("]\n");
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
		IndentLevel--;
		writeIndent();
		sbuilder.append("}\n");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParameterList(MiniJavaParser.ParameterListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParameterList(MiniJavaParser.ParameterListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParameter(MiniJavaParser.ParameterContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParameter(MiniJavaParser.ParameterContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethodBody(MiniJavaParser.MethodBodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethodBody(MiniJavaParser.MethodBodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterType(MiniJavaParser.TypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitType(MiniJavaParser.TypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBooleanType(MiniJavaParser.BooleanTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBooleanType(MiniJavaParser.BooleanTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIntType(MiniJavaParser.IntTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIntType(MiniJavaParser.IntTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterReturnType(MiniJavaParser.ReturnTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitReturnType(MiniJavaParser.ReturnTypeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAccessModifier(MiniJavaParser.AccessModifierContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAccessModifier(MiniJavaParser.AccessModifierContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNestedStatement(MiniJavaParser.NestedStatementContext ctx) {
		writeIndent();
		sbuilder.append("nested statement{\n");
		IndentLevel++;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNestedStatement(MiniJavaParser.NestedStatementContext ctx) {
		IndentLevel--;
		writeIndent();
		sbuilder.append("}\n");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfElseStatement(MiniJavaParser.IfElseStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfElseStatement(MiniJavaParser.IfElseStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhileStatement(MiniJavaParser.WhileStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhileStatement(MiniJavaParser.WhileStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrintStatement(MiniJavaParser.PrintStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrintStatement(MiniJavaParser.PrintStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVariableAssignmentStatement(MiniJavaParser.VariableAssignmentStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVariableAssignmentStatement(MiniJavaParser.VariableAssignmentStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArrayAssignmentStatement(MiniJavaParser.ArrayAssignmentStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArrayAssignmentStatement(MiniJavaParser.ArrayAssignmentStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLocalVarDeclaration(MiniJavaParser.LocalVarDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLocalVarDeclaration(MiniJavaParser.LocalVarDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpressioncall(MiniJavaParser.ExpressioncallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpressioncall(MiniJavaParser.ExpressioncallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIfBlock(MiniJavaParser.IfBlockContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIfBlock(MiniJavaParser.IfBlockContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElseBlock(MiniJavaParser.ElseBlockContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElseBlock(MiniJavaParser.ElseBlockContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhileBlock(MiniJavaParser.WhileBlockContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhileBlock(MiniJavaParser.WhileBlockContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLtExpression(MiniJavaParser.LtExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLtExpression(MiniJavaParser.LtExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterObjectInstantiationExpression(MiniJavaParser.ObjectInstantiationExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitObjectInstantiationExpression(MiniJavaParser.ObjectInstantiationExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArrayInstantiationExpression(MiniJavaParser.ArrayInstantiationExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArrayInstantiationExpression(MiniJavaParser.ArrayInstantiationExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPowExpression(MiniJavaParser.PowExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPowExpression(MiniJavaParser.PowExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIdentifierExpression(MiniJavaParser.IdentifierExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIdentifierExpression(MiniJavaParser.IdentifierExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMethodCallExpression(MiniJavaParser.MethodCallExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMethodCallExpression(MiniJavaParser.MethodCallExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNotExpression(MiniJavaParser.NotExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNotExpression(MiniJavaParser.NotExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBooleanLitExpression(MiniJavaParser.BooleanLitExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBooleanLitExpression(MiniJavaParser.BooleanLitExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParenExpression(MiniJavaParser.ParenExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParenExpression(MiniJavaParser.ParenExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIntLitExpression(MiniJavaParser.IntLitExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIntLitExpression(MiniJavaParser.IntLitExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNullLitExpression(MiniJavaParser.NullLitExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNullLitExpression(MiniJavaParser.NullLitExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAndExpression(MiniJavaParser.AndExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAndExpression(MiniJavaParser.AndExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArrayAccessExpression(MiniJavaParser.ArrayAccessExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArrayAccessExpression(MiniJavaParser.ArrayAccessExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAddExpression(MiniJavaParser.AddExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAddExpression(MiniJavaParser.AddExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterThisExpression(MiniJavaParser.ThisExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitThisExpression(MiniJavaParser.ThisExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFieldCallExpression(MiniJavaParser.FieldCallExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFieldCallExpression(MiniJavaParser.FieldCallExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArrayLengthExpression(MiniJavaParser.ArrayLengthExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArrayLengthExpression(MiniJavaParser.ArrayLengthExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIntarrayInstantiationExpression(MiniJavaParser.IntarrayInstantiationExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIntarrayInstantiationExpression(MiniJavaParser.IntarrayInstantiationExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSubExpression(MiniJavaParser.SubExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSubExpression(MiniJavaParser.SubExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMulExpression(MiniJavaParser.MulExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMulExpression(MiniJavaParser.MulExpressionContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }

	private void writeIndent(){
		for(int i = 0; i < IndentLevel * 4; i++){
			sbuilder.append(" ");
		}
	}
}