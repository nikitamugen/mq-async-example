package ru.nikitamugen.mqasyncexample;

import org.apache.activemq.broker.BrokerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import ru.nikitamugen.mqasyncexample.api.MessageErrorHandler;

import java.net.URI;

@EnableJms
@Configuration
public class ActiveMQConfiguration {
    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    private static Logger logger = Logger.getLogger(ActiveMQConfiguration.class);

    @Autowired
    private MessageErrorHandler messageErrorHandler;

    @Bean(initMethod="start", destroyMethod="stop")
    public BrokerService broker() throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.addConnector(new URI(brokerUrl));
        brokerService.setBrokerName("async-example");
        brokerService.setPersistent(false);
        brokerService.setUseJmx(true);
        brokerService.setStartAsync(true);
        brokerService.setUseShutdownHook(false);

        return brokerService;
    }

    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setMessageConverter(messageConverter());
        factory.setErrorHandler(messageErrorHandler);
        return factory;
    }

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
