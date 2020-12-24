package com.rabbitmq.listener;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {

    @Bean
    Exchange exampleExchange() {
        return new TopicExchange("Create Exchange With Class");
    }

    @Bean
    Exchange newDirectExchange() {
        return ExchangeBuilder
                .directExchange("Direct Exchange")
                .autoDelete()
                .internal()
                .build();
    }

    @Bean
    Exchange newTopicExchange() {
        return ExchangeBuilder
                .topicExchange("Topic Exchange")
                .autoDelete()
                .internal()
                .durable(true)
                .build();
    }

    @Bean
    Exchange newFanoutExchange() {
        return ExchangeBuilder
                .fanoutExchange("Fanout Exchange")
                .autoDelete()
                .internal()
                .durable(false)
                .build();
    }

    @Bean
    Exchange newHeadersExchange() {
        return ExchangeBuilder
                .headersExchange("Headers Exchange")
                .autoDelete()
                .internal()
                .durable(true)
                .ignoreDeclarationExceptions()
                .build();
    }
}
