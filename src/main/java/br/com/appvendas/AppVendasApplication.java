package br.com.appvendas;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.appvendas.services.S3Service;


@SpringBootApplication
public class AppVendasApplication implements CommandLineRunner {

	@Autowired
	private S3Service s3Service;

	
	public static void main(String[] args) {
		SpringApplication.run(AppVendasApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		s3Service.uploadFile("D:\\AppVendas\\fotos\\lua.jpg");
	}
	
	
}
