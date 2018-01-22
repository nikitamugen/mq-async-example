package ru.nikitamugen.mqasyncexample.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.stereotype.Service;
import ru.nikitamugen.mqasyncexample.api.request.WordRequest;

import javax.jms.Message;

@Service
public class MessageSender implements InitializingBean {
    private static final String wordsQueueName = "queue.words";

    private static MessageSender instance;
    public static MessageSender getInstance() {
        return instance;
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    public Message send(WordRequest wordRequest) {
        final SessionCallback<Message> sessionCallback = new MessageSenderConsumer(wordRequest, jmsTemplate, wordsQueueName);
        return jmsTemplate.execute(sessionCallback, true);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        instance = this;
    }
}
