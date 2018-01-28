package ru.nikitamugen.mqasyncexample.api;

import org.apache.log4j.Logger;
import ru.nikitamugen.mqasyncexample.api.request.WordRequest;

import javax.jms.*;

public class MessageListener implements javax.jms.MessageListener {

    private static Logger logger = Logger.getLogger(MessageListener.class);

    private final WordRequest wordRequest;
    private final Connection connection;
    private final Session session;

    MessageListener(WordRequest wordRequest, Connection connection, Session session) {
        this.wordRequest = wordRequest;
        this.connection = connection;
        this.session = session;
        logger.info("Message " + wordRequest.toString() + " sent. Waiting for response...");
    }

    @Override
    public void onMessage(Message message) {
        try {
            connection.close();
            session.close();

            TextMessage textMessage = (TextMessage) message;
            String messageText = textMessage.getText();
            logger.info(messageText);
        } catch (JMSException e) {
            logger.error(e.getMessage());
        }
    }
}
