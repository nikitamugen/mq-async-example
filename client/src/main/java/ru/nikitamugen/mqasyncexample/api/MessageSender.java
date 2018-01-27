package ru.nikitamugen.mqasyncexample.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import ru.nikitamugen.mqasyncexample.Settings;
import ru.nikitamugen.mqasyncexample.api.request.WordRequest;

import javax.jms.*;
import java.util.Random;

public class MessageSender {
    private static int ackMode;
    private static boolean transacted;
    private static String queueName;
    private static int deliveryMode;

    private static Logger logger;

    static {
        queueName = "queue.words";
        transacted = false;
        ackMode = Session.AUTO_ACKNOWLEDGE;
        deliveryMode = DeliveryMode.NON_PERSISTENT;
        logger = Logger.getLogger(MessageSender.class);
    }

    public void send(WordRequest wordRequest) {
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory(Settings.INSTANCE.getBrokerUrl());
        Connection connection;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(transacted, ackMode);
            Destination adminQueue = session.createQueue(queueName);

            //Setup a message producer to send message to the queue the server is consuming from
            final MessageProducer messageProducer;
            messageProducer = session.createProducer(adminQueue);
            messageProducer.setDeliveryMode(deliveryMode);

            //Create a temporary queue that this client will listen for responses on then create a consumer
            //that consumes message from this temporary queue...for a real application a client should reuse
            //the same temp queue for each message to the server...one temp queue per client
            Destination tempDest = session.createTemporaryQueue();
            MessageConsumer responseConsumer = session.createConsumer(tempDest);

            //This class will handle the messages to the temp queue as well
            final MessageListener messageListener = new MessageListener(wordRequest);
            responseConsumer.setMessageListener(messageListener);

            //Now create the actual message you want to send
            final ObjectMapper objectMapper = new ObjectMapper();
            final String jsonMessage = objectMapper.writeValueAsString(wordRequest);
            Message message = session.createTextMessage(jsonMessage);

            //Set the reply to field to the temp queue you created above, this is the queue the server
            //will respond to
            message.setJMSReplyTo(tempDest);

            //Set a correlation ID so when you get a response you know which sent message the response is for
            //If there is never more than one outstanding message to the server then the
            //same correlation ID can be used for all the messages...if there is more than one outstanding
            //message to the server you would presumably want to associate the correlation ID with this
            //message somehow...a Map works good
            String correlationId = this.createRandomString();
            message.setJMSCorrelationID(correlationId);
            messageProducer.send(message);
        } catch (JMSException ex) {
            logger.error(ex.getMessage());
        } catch (JsonProcessingException ex) {
            logger.error(ex.getMessage());
        }
    }

    private String createRandomString() {
        Random random = new Random(System.currentTimeMillis());
        long randomLong = random.nextLong();
        return Long.toHexString(randomLong);
    }
}
