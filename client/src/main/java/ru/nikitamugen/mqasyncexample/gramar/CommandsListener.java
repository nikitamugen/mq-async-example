// Generated from Commands.g4 by ANTLR 4.7.1
package ru.nikitamugen.mqasyncexample.gramar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CommandsParser}.
 */
public interface CommandsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CommandsParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(CommandsParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(CommandsParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#addCommand}.
	 * @param ctx the parse tree
	 */
	void enterAddCommand(CommandsParser.AddCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#addCommand}.
	 * @param ctx the parse tree
	 */
	void exitAddCommand(CommandsParser.AddCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#deleteCommand}.
	 * @param ctx the parse tree
	 */
	void enterDeleteCommand(CommandsParser.DeleteCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#deleteCommand}.
	 * @param ctx the parse tree
	 */
	void exitDeleteCommand(CommandsParser.DeleteCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#getCommand}.
	 * @param ctx the parse tree
	 */
	void enterGetCommand(CommandsParser.GetCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#getCommand}.
	 * @param ctx the parse tree
	 */
	void exitGetCommand(CommandsParser.GetCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#helpCommand}.
	 * @param ctx the parse tree
	 */
	void enterHelpCommand(CommandsParser.HelpCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#helpCommand}.
	 * @param ctx the parse tree
	 */
	void exitHelpCommand(CommandsParser.HelpCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#exitCommand}.
	 * @param ctx the parse tree
	 */
	void enterExitCommand(CommandsParser.ExitCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#exitCommand}.
	 * @param ctx the parse tree
	 */
	void exitExitCommand(CommandsParser.ExitCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(CommandsParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(CommandsParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CommandsParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CommandsParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CommandsParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CommandsParser.ValueContext ctx);
}