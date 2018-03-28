package br.com.appvendas.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.appvendas.domain.Pedido;


public interface EmailService {

	void sendOrderConfimationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
