package ru.nikitamugen.mqasyncexample.executors;

import org.apache.log4j.Logger;
import ru.nikitamugen.mqasyncexample.api.MessageSender;
import ru.nikitamugen.mqasyncexample.api.request.WordRequest;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class AddCommandExecutor implements Runnable {

    Logger logger = Logger.getLogger(AddCommandExecutor.class);

    private final String code;
    private final String value;

    public AddCommandExecutor(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public void run() {
        WordRequest request = WordRequest.createAddWord(code, value);
        MessageSender messageSender = MessageSender.getInstance();
        TextMessage response = (TextMessage)messageSender.send(request);

        try {
            logger.info(response.getText());
        } catch (JMSException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
}
