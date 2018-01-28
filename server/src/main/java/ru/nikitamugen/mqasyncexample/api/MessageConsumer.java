package ru.nikitamugen.mqasyncexample.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import ru.nikitamugen.mqasyncexample.api.request.WordRequestTypes;
import ru.nikitamugen.mqasyncexample.api.request.AddWord;
import ru.nikitamugen.mqasyncexample.api.request.DeleteWord;
import ru.nikitamugen.mqasyncexample.api.request.GetWord;
import ru.nikitamugen.mqasyncexample.api.request.WordRequest;
import ru.nikitamugen.mqasyncexample.exception.AlreadyExistsException;
import ru.nikitamugen.mqasyncexample.exception.KeyNotFoundException;
import ru.nikitamugen.mqasyncexample.exception.KeyOrValueNotFoundException;
import ru.nikitamugen.mqasyncexample.service.WordsService;

import javax.jms.*;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class MessageConsumer {
    private static Logger logger = Logger.getLogger(MessageConsumer.class);

    private static final String wordsQueueName = "queue.words";

    @Autowired
    WordsService wordsService;

    // Concurrency set to 1 thread max
    // for each message in this queue
    //
    @JmsListener(destination = wordsQueueName, concurrency = "1-1")
    public void receiveMessage(@Headers MessageHeaders headers,
                               TextMessage message, Session session)
            throws InterruptedException {

        try {
            final String correlationId = message.getJMSCorrelationID();
            logger.info("Got message: " + message.getText());
            WordRequest request = WordRequest.createFromJsonString(message.getText());

            // Dramatic pause ...
            //
            CountDownLatch latch = new CountDownLatch(1);
            latch.await(5000, TimeUnit.MILLISECONDS);

            logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");
            logger.info("received <" + request + "> id: <" + correlationId + ">");
            logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");
            logger.info("######              Details               #####");
            logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");
            logger.info("headers: " + headers);
            logger.info("message: " + message);
            logger.info("session: " + session);
            logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");

            Message response = handleRequest(request, session);
            response.setJMSCorrelationID(message.getJMSCorrelationID());

            logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");
            logger.info("got response for id: <" + correlationId + ">");
            logger.info("response:      " + response);
            logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");

            MessageProducer replyProducer = session.createProducer(message.getJMSReplyTo());
            replyProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            replyProducer.send(message.getJMSReplyTo(), response);

            logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");
            logger.info("sent response for id: <" + correlationId + ">");
            logger.info("- - - - - - - - - - - - - - - - - - - - - - - -");
        } catch (JMSException ex) {
            logger.error(ex);
        }
    }

    private Message handleRequest(final WordRequest request, final Session session)
            throws JMSException {

        final WordRequestTypes wordMessageType = request.getType();
        switch (wordMessageType) {
            case ADD:
                return addWordHandler((AddWord) request, session);
            case GET:
                return getWordHandler((GetWord) request, session);
            case DELETE:
                return deleteWordHandler((DeleteWord) request, session);

            default:
                return createTextResponse("Тип запроса неизвестен", session);
        }
    }

    private Message addWordHandler(final AddWord request, final Session session)
            throws JMSException {

        try {
            final String code = request.getCode();
            final String value = request.getValue();
            wordsService.add(code, value);

            final String format = "<значение '%s' слова '%s' успешно добавлено>";
            final String text = String.format(format, value, code);
            return createTextResponse(text, session);
        } catch (AlreadyExistsException ex) {
            final String text = ex.getMessage();
            return createTextResponse(text, session);
        }
    }

    private Message getWordHandler(final GetWord request, final Session session)
            throws JMSException {

        try {
            List<String> values = wordsService.get(request.getCode());
            String text;
            if (values.isEmpty()) {
                text = "<Нечего показывать>";
            } else {
                final String separator = System.getProperty("line.separator");
                text = String.join(separator, values);
            }
            return createTextResponse(text, session);
        } catch (KeyNotFoundException ex) {
            final String text = ex.getMessage();
            return createTextResponse(text, session);
        }
    }

    private Message deleteWordHandler(final DeleteWord request, final Session session)
            throws JMSException {

        try {
            final String code = request.getCode();
            final String value = request.getValue();
            wordsService.remove(code, value);

            final String format = "<значение '%s' слова '%s' успешно удалено>";
            final String text = String.format(format, value, code);
            return createTextResponse(text, session);
        } catch (KeyOrValueNotFoundException ex) {
            final String text = ex.getMessage();
            return createTextResponse(text, session);
        } catch (KeyNotFoundException ex) {
            final String text = ex.getMessage();
            return createTextResponse(text, session);
        }
    }

    private Message createTextResponse(String text, Session session)
            throws JMSException {

        return session.createTextMessage(text);
    }
}
