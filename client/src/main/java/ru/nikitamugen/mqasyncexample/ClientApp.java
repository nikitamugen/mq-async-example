package ru.nikitamugen.mqasyncexample;

import com.google.common.base.Strings;
import org.apache.log4j.Logger;
import org.junit.Assert;
import ru.nikitamugen.mqasyncexample.executors.AddCommandExecutor;
import ru.nikitamugen.mqasyncexample.executors.DeleteCommandExecutor;
import ru.nikitamugen.mqasyncexample.executors.GetCommandExecutor;
import ru.nikitamugen.mqasyncexample.parser.GramarParser;
import ru.nikitamugen.mqasyncexample.parser.ParserResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientApp {

    private static Logger logger = Logger.getLogger("ClientApp");
    private static Logger protocolLogger = Logger.getLogger("Input");

    public static void main(String[] args) {
        initSettings(args[0], args[1]);
        startRead();
    }

    private static void initSettings(String brokerHost, String brokerPort) {
        Assert.assertFalse(Strings.isNullOrEmpty(brokerHost));
        Assert.assertFalse(Strings.isNullOrEmpty(brokerPort));

        Settings.INSTANCE.setBrokerHost(brokerHost);
        Settings.INSTANCE.setBrokerPort(brokerPort);

        logger.info("Uses broker url: "+Settings.INSTANCE.getBrokerUrl());
    }

    private static void startRead() {

        logger.info(
                "Type 'help' or '?' to get some information about syntax.\n" +
                "If you know what you doing... Then, well. Just begin ! :)");

        BufferedReader br = null;
        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                String input = br.readLine();
                protocolLogger.info(input);

                ParserResult result = GramarParser.parse(input);
                if (result.needExit) {
                    break;
                }
                if (result.needHelp) {
                    typeHelp();
                    continue;
                }

                switch (result.command) {
                    case ParserResult.ADD:
                        createAndRunAddExecutors(result);
                        break;

                    case ParserResult.DELETE:
                        createAndRunDeleteExecutors(result);
                        break;

                    case ParserResult.GET:
                        createAndRunGetExecutors(result);
                        break;

                    default:
                        logger.error("Don't get it... Try again !");
                        typeHelp();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            logger.info("Bye !");
        }
    }

    private static void typeHelp() {
        logger.info("Help:");
        logger.info("add <word> <value1> [<value2> ...] - append values of the word to the dictionary.");
        logger.info("get <word> - get values of the word");
        logger.info("delete <word> <value1> [<value2> ...] - remove values of the word");
        logger.info("exit / quit / q - close this app");
        logger.info("help / ? - shows me :)");
    }

    private static void createAndRunAddExecutors(ParserResult parserResult) {
        parserResult.values.forEach(value -> {
            AddCommandExecutor executor = new AddCommandExecutor(parserResult.code, value);
            executor.run();
        });
    }

    private static void createAndRunDeleteExecutors(ParserResult parserResult) {
        parserResult.values.forEach(value -> {
            DeleteCommandExecutor executor = new DeleteCommandExecutor(parserResult.code, value);
            executor.run();
        });
    }

    private static void createAndRunGetExecutors(ParserResult parserResult) {
        GetCommandExecutor executor = new GetCommandExecutor(parserResult.code);
        executor.run();
    }
}
