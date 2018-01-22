package ru.nikitamugen.mqasyncexample;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.*;
import javax.jms.Message;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class TestConsumer {

    private Logger logger = Logger.getLogger(TestConsumer.class);

    public static final String testQueue = "queue.test";

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @JmsListener(destination = testQueue)
    public void receiveMessage(@Payload String textMessage,
                               @Headers MessageHeaders headers,
                               Message request, Session session) throws JMSException {
        logger.info("Dramatic pause before response");
        try {
            latch.await(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            logger.info("Hmmm... Somebody interrupted await.'");
        }
        logger.info("Yep! Received '" + textMessage + "'");
        latch.countDown();

        Message response = session.createTextMessage("Got it!");
        response.setJMSCorrelationID(request.getJMSCorrelationID());

        MessageProducer replyProducer = session.createProducer(request.getJMSReplyTo());
        replyProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        replyProducer.send(request.getJMSReplyTo(), response);
    }
}
