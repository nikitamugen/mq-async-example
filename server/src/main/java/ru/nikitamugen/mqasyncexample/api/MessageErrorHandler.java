package ru.nikitamugen.mqasyncexample.api;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class MessageErrorHandler implements ErrorHandler {

    private static Logger logger = Logger.getLogger(MessageErrorHandler.class);

    @Override
    public void handleError(Throwable t) {
        logger.error(t.getMessage(), t);
    }
}
