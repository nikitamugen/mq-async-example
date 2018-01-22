// Generated from commands.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link commandsParser}.
 */
public interface commandsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link commandsParser#addCommand}.
	 * @param ctx the parse tree
	 */
	void enterAddCommand(commandsParser.AddCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link commandsParser#addCommand}.
	 * @param ctx the parse tree
	 */
	void exitAddCommand(commandsParser.AddCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link commandsParser#getCommand}.
	 * @param ctx the parse tree
	 */
	void enterGetCommand(commandsParser.GetCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link commandsParser#getCommand}.
	 * @param ctx the parse tree
	 */
	void exitGetCommand(commandsParser.GetCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link commandsParser#deleteCommand}.
	 * @param ctx the parse tree
	 */
	void enterDeleteCommand(commandsParser.DeleteCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link commandsParser#deleteCommand}.
	 * @param ctx the parse tree
	 */
	void exitDeleteCommand(commandsParser.DeleteCommandContext ctx);
}