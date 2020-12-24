package com.rabbitmq.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMQListener {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMQListener.class, args);
	}
}
