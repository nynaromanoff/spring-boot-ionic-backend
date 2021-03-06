package br.com.appvendas.services;


import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import br.com.appvendas.domain.Cliente;
import br.com.appvendas.domain.Pedido;


public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
	
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
}
