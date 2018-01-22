package ru.nikitamugen.mqasyncexample.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import ru.nikitamugen.mqasyncexample.gramar.*;

import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class GramarParser {

    public static ParserResult parse(String someLangSourceCode) {
        CharStream charStream = new ANTLRInputStream(someLangSourceCode);
        CommandsLexer lexer = new CommandsLexer(charStream);
        TokenStream tokens = new CommonTokenStream(lexer);
        CommandsParser parser = new CommandsParser(tokens);

        ClassVisitor classVisitor = new ClassVisitor();
        ParserResult result = classVisitor.visit(parser.command());
        return result;
    }

    private static class ClassVisitor extends CommandsBaseVisitor<ParserResult> {
        @Override
        public ParserResult visitCommand(CommandsParser.CommandContext ctx) {
            ParserResult result;
            if (Objects.nonNull(ctx.addCommand())) {
                result = ctx.addCommand().accept(new AddCommandVisitor());
            } else if (Objects.nonNull(ctx.deleteCommand())) {
                result = ctx.deleteCommand().accept(new DeleteCommandVisitor());
            } else if (Objects.nonNull(ctx.getCommand())) {
                result = ctx.getCommand().accept(new GetCommandVisitor());
            } else if (Objects.nonNull(ctx.exitCommand())) {
                result = new ParserResult();
                result.command = ParserResult.EXIT;
                result.needExit = true;
            } else if (Objects.nonNull(ctx.helpCommand())) {
                result = new ParserResult();
                result.command = ParserResult.HELP;
                result.needHelp = true;
            } else {
                result = new ParserResult();
                result.command = ParserResult.UNKNOWN;
                result.needHelp = true;
            }

            return result;
        }
    }

    private static class AddCommandVisitor extends CommandsBaseVisitor<ParserResult> {
        @Override
        public ParserResult visitAddCommand(CommandsParser.AddCommandContext ctx) {
            ParserResult result = new ParserResult();
            result.command = ParserResult.ADD;
            result.code = ctx.code().WORD()
                    .toString();
            result.values = ctx.value()
                    .stream()
                    .map(valueContext -> valueContext.accept(new ValueVisitor()))
                    .collect(toList());
            return result;
        }
    }

    private static class DeleteCommandVisitor extends CommandsBaseVisitor<ParserResult> {
        @Override
        public ParserResult visitDeleteCommand(CommandsParser.DeleteCommandContext ctx) {
            ParserResult result = new ParserResult();
            result.command = ParserResult.DELETE;
            result.code = ctx.code().WORD()
                    .toString();
            result.values = ctx.value()
                    .stream()
                    .map(valueContext -> valueContext.accept(new ValueVisitor()))
                    .collect(toList());
            return result;
        }
    }

    private static class GetCommandVisitor extends CommandsBaseVisitor<ParserResult> {
        @Override
        public ParserResult visitGetCommand(CommandsParser.GetCommandContext ctx) {
            ParserResult result = new ParserResult();
            result.command = ParserResult.GET;
            result.code = ctx.code().WORD()
                    .toString();
            return result;
        }
    }

    private static class ValueVisitor extends CommandsBaseVisitor<String> {
        @Override
        public String visitValue(CommandsParser.ValueContext ctx) {
            return ctx.WORD().toString();
        }
    }
}
