package ru.nikitamugen.mqasyncexample;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.nikitamugen.mqasyncexample.executors.AddCommandExecutor;
import ru.nikitamugen.mqasyncexample.executors.DeleteCommandExecutor;
import ru.nikitamugen.mqasyncexample.executors.GetCommandExecutor;
import ru.nikitamugen.mqasyncexample.parser.GramarParser;
import ru.nikitamugen.mqasyncexample.parser.ParserResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class ClientApp {

    private static Logger logger = Logger.getLogger(ClientApp.class);

    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);
        startRead();
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
                ParserResult result = GramarParser.parse(input);
                if (result.needExit) {
                    break;
                }
                if (result.needHelp) {
                    typeHelp();
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
        logger.info("Помощь:");
        logger.info("add <слово> <значение1> [<значение2> ...] - добавляет в словарь указанные значения слова," +
                " сохраняя при это старые");
        logger.info("get <слово> - возвращает значения слова, каждое слово должно начинаться с новой строки. " +
                "В случае если искомого слова в словаре не содержится, приложение должно сообщить об этом.");
        logger.info("delete <слово> <значение1> [<значение2> ...] - удаляет из словаря указанные значения слова");
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
