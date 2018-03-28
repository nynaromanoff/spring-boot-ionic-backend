package br.com.appvendas.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.appvendas.services.DBService;
import br.com.appvendas.services.EmailService;
import br.com.appvendas.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instatiateDatabase() throws ParseException{
		
		dbService.instatiateTestDataBase();
		return true;
	}
	
	@Bean
	public EmailService emailService(){
		return new MockEmailService();
	}
}
