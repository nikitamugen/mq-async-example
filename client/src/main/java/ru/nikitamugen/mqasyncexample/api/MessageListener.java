package ru.nikitamugen.mqasyncexample.api;

import org.apache.log4j.Logger;
import ru.nikitamugen.mqasyncexample.api.request.WordRequest;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class MessageListener implements javax.jms.MessageListener {

    private static Logger logger = Logger.getLogger(MessageListener.class);

    private final WordRequest wordRequest;

    MessageListener(WordRequest wordRequest) {
        this.wordRequest = wordRequest;
        logger.info("Message " + wordRequest.toString() + " sent. Waiting for response...");
    }

    @Override
    public void onMessage(Message message) {
        String messageText = null;
        try {
            TextMessage textMessage = (TextMessage) message;
            messageText = textMessage.getText();
            logger.info(messageText);
        } catch (JMSException e) {
            logger.error(e.getMessage());
        }
    }
}
