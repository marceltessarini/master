package com.tessarini.perfilcliente;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PerfilClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfilClienteApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRespository repo) {
		return (evt) -> {
			repo.save(new Cliente("Adam", "adam@boot.com"));
			repo.save(new Cliente("John", "john@boot.com"));
			repo.save(new Cliente("Smith", "smith@boot.com"));
			repo.save(new Cliente("Edgar", "edgar@boot.com"));
			repo.save(new Cliente("Martin", "martin@boot.com"));
			repo.save(new Cliente("Tom", "tom@boot.com"));
			repo.save(new Cliente("Sean", "sean@boot.com"));
		};
	}
}
