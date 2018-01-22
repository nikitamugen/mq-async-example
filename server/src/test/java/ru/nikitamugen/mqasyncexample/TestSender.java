package ru.nikitamugen.mqasyncexample;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.stereotype.Component;
import ru.nikitamugen.mqasyncexample.api.MessageSenderConsumer;

import javax.jms.Message;
import java.util.concurrent.CountDownLatch;

@Component
public class TestSender {

    private Logger logger = Logger.getLogger(TestSender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    public void send(String textMessage) {
        final SessionCallback<Message> sessionCallback = new MessageSenderConsumer(textMessage, jmsTemplate, TestConsumer.testQueue);
        Message response = jmsTemplate.execute(sessionCallback, true);
        logger.info("Got message '"+response.toString()+"'");
        latch.countDown();
    }
}
