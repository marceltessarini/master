package com.tessarini.notificacaocliente;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
class Receiver {
	@Autowired
	Mailer mailer;

	@Bean
	Queue queue() {
		return new Queue("ClienteQ", false);
	}

	@RabbitListener(queues = "ClienteQ")
	public void processMessage(String email) {
		System.out.println(email);
		mailer.sendMail(email);
	}
}