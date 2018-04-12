package br.com.appvendas.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmailDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String email;
	
	@NotEmpty(message= "Preenchimento Obrigatório!")
	@Email(message= "E-mail Inválido!")
	public EmailDTO(){
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
