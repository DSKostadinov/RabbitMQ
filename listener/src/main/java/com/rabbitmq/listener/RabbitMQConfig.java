package com.rabbitmq.listener;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    Queue createQueue() {
        return QueueBuilder
                .durable("New RabbitMQ Queue")
                .autoDelete()
                .build();
    }

    @Bean
    Exchange createExchange() {
        return ExchangeBuilder
                .topicExchange("New RabbitMQ Topic Exchange")
                .durable(false)
                .build();
    }

    @Bean
    Binding createBinding() {
        return BindingBuilder
                .bind(createQueue())
                .to(createExchange())
                .with("topic")
                .noargs();
    }
    @Bean
    ConnectionFactory createConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");

        return cachingConnectionFactory;
    }

    @Bean
    MessageListenerContainer createMessageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(createConnectionFactory());
        simpleMessageListenerContainer.setQueues(createQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitMQMessageListener());

        return simpleMessageListenerContainer;
    }
}
