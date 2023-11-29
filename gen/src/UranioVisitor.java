// Generated from C:/Users/rodri/Projects/compiler-uranio/src/Uranio.g4 by ANTLR 4.13.1
package gen.src;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UranioParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UranioVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UranioParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(UranioParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(UranioParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(UranioParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(UranioParser.IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#elseIfBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfBlock(UranioParser.ElseIfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#whileBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileBlock(UranioParser.WhileBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#assigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigment(UranioParser.AssigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#typeAssigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAssigment(UranioParser.TypeAssigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(UranioParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(UranioParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(UranioParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#multOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultOp(UranioParser.MultOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(UranioParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#compareOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareOp(UranioParser.CompareOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#booleanOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanOp(UranioParser.BooleanOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(UranioParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link UranioParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(UranioParser.BlockContext ctx);
}