package ru.nikitamugen.mqasyncexample.executors;

import org.apache.log4j.Logger;
import ru.nikitamugen.mqasyncexample.api.MessageSender;
import ru.nikitamugen.mqasyncexample.api.request.WordRequest;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class GetCommandExecutor implements Runnable {

    Logger logger = Logger.getLogger(GetCommandExecutor.class);

    private final String code;

    public GetCommandExecutor(String code) {
        this.code = code;
    }

    @Override
    public void run() {
        WordRequest request = WordRequest.createGetWord(code);
        MessageSender messageSender = new MessageSender();
        messageSender.send(request);
    }
}
