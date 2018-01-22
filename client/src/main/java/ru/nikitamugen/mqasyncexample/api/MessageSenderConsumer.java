package ru.nikitamugen.mqasyncexample.api;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.jms.support.JmsUtils;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.destination.DestinationResolver;

import javax.jms.*;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import java.util.UUID;

public class MessageSenderConsumer implements SessionCallback<Message> {
    private Logger logger = Logger.getLogger(MessageSenderConsumer.class);

    private Object messageObject;

    private final DestinationResolver destinationResolver;

    private final String queue;

    private final JmsTemplate jmsTemplate;

    public MessageSenderConsumer(final Object messageObject, final JmsTemplate jmsTemplate, String queue) {
        this.messageObject = messageObject;
        this.jmsTemplate = jmsTemplate;
        this.destinationResolver = jmsTemplate.getDestinationResolver();
        this.queue = queue;
    }

    @Override
    public Message doInJms(final Session session) throws JMSException {
        MessageConsumer consumer = null;
        MessageProducer producer = null;
        try {
            final Destination requestQueue =
                    destinationResolver.resolveDestinationName(session, queue, false);

            final String outputDestinationQueue = queue+".output";
            final Destination replyQueue =
                    destinationResolver.resolveDestinationName(session, outputDestinationQueue, false);

            final String correlationId = UUID.randomUUID().toString();
            final String messageSelector = "JMSCorrelationID = '" + correlationId + "'";
            consumer = session.createConsumer(replyQueue, messageSelector);

            final MessageConverter messageConverter = jmsTemplate.getMessageConverter();
            final Message message = messageConverter.toMessage(messageObject, session);
            message.setJMSCorrelationID(correlationId);
            message.setJMSReplyTo(replyQueue);

            logger.info("Send '" + messageObject.toString() + "' to '" + queue + "' with id '" + correlationId + "'");
            producer = session.createProducer(requestQueue);
            producer.send(requestQueue, message);

            logger.info("Wait response for id '" + correlationId + "' from '" + outputDestinationQueue + "'");
            return consumer.receive();
        }
        finally {
            // Don't forget to close your resources
            JmsUtils.closeMessageConsumer(consumer);
            JmsUtils.closeMessageProducer(producer);
        }
    }
}
