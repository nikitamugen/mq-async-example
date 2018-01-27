package ru.nikitamugen.mqasyncexample.executors;

import org.apache.log4j.Logger;
import ru.nikitamugen.mqasyncexample.api.MessageSender;
import ru.nikitamugen.mqasyncexample.api.request.WordRequest;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class DeleteCommandExecutor implements Runnable {

    Logger logger = Logger.getLogger(DeleteCommandExecutor.class);

    private final String code;
    private final String value;

    public DeleteCommandExecutor(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public void run() {
        WordRequest request = WordRequest.createDeleteWord(code, value);
        MessageSender messageSender = new MessageSender();
        messageSender.send(request);
    }
}
