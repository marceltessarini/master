package com.tessarini.notificacaocliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
class Mailer {
	@Autowired
	private JavaMailSender javaMailService;

	public void sendMail(String email) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email);
		mailMessage.setSubject("Registro");
		mailMessage.setText("Registrado com sucesso");
		javaMailService.send(mailMessage);
	}
}
