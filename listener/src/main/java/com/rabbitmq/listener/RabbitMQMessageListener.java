package com.rabbitmq.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class RabbitMQMessageListener implements MessageListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(RabbitMQMessageListener.class);

    @Override
    public void onMessage(Message message) {
        LOGGER.info("message = [" + new String(message.getBody()) + "]");
    }
}
