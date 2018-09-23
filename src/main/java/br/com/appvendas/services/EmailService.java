package br.com.appvendas.services;


import org.springframework.mail.SimpleMailMessage;

import br.com.appvendas.domain.Cliente;
import br.com.appvendas.domain.Pedido;


public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
}
