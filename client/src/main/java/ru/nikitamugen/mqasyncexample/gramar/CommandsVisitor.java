// Generated from Commands.g4 by ANTLR 4.5.1
package ru.nikitamugen.mqasyncexample.gramar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CommandsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CommandsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CommandsParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(CommandsParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link CommandsParser#addCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddCommand(CommandsParser.AddCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link CommandsParser#deleteCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteCommand(CommandsParser.DeleteCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link CommandsParser#getCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetCommand(CommandsParser.GetCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link CommandsParser#helpCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHelpCommand(CommandsParser.HelpCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link CommandsParser#exitCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitCommand(CommandsParser.ExitCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link CommandsParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(CommandsParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CommandsParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CommandsParser.ValueContext ctx);
}