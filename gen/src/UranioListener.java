// Generated from C:/Users/rodri/Projects/compiler-uranio/src/Uranio.g4 by ANTLR 4.13.1
package gen.src;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UranioParser}.
 */
public interface UranioListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UranioParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(UranioParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(UranioParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(UranioParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(UranioParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(UranioParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(UranioParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(UranioParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(UranioParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseIfBlock(UranioParser.ElseIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#elseIfBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseIfBlock(UranioParser.ElseIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void enterWhileBlock(UranioParser.WhileBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void exitWhileBlock(UranioParser.WhileBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#assigment}.
	 * @param ctx the parse tree
	 */
	void enterAssigment(UranioParser.AssigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#assigment}.
	 * @param ctx the parse tree
	 */
	void exitAssigment(UranioParser.AssigmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#typeAssigment}.
	 * @param ctx the parse tree
	 */
	void enterTypeAssigment(UranioParser.TypeAssigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#typeAssigment}.
	 * @param ctx the parse tree
	 */
	void exitTypeAssigment(UranioParser.TypeAssigmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(UranioParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(UranioParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(UranioParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(UranioParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(UranioParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(UranioParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(UranioParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(UranioParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(UranioParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(UranioParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#compareOp}.
	 * @param ctx the parse tree
	 */
	void enterCompareOp(UranioParser.CompareOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#compareOp}.
	 * @param ctx the parse tree
	 */
	void exitCompareOp(UranioParser.CompareOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#booleanOp}.
	 * @param ctx the parse tree
	 */
	void enterBooleanOp(UranioParser.BooleanOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#booleanOp}.
	 * @param ctx the parse tree
	 */
	void exitBooleanOp(UranioParser.BooleanOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(UranioParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(UranioParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link UranioParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(UranioParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link UranioParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(UranioParser.BlockContext ctx);
}