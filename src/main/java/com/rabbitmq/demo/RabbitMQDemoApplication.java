package com.rabbitmq.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMQDemoApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMQDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleMessage simpleMessage = new SimpleMessage();
		simpleMessage.setName("Name");
		simpleMessage.setDescription("Description");

		rabbitTemplate.convertAndSend("New RabbitMQ Topic Exchange", "topic", simpleMessage);
	}
}
