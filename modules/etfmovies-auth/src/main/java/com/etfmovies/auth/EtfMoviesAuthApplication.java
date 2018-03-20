package com.etfmovies.auth;

import com.etfmovies.auth.models.Credentials;
import com.etfmovies.auth.repositories.CredentialsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtfMoviesAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtfMoviesAuthApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CredentialsRepository repository) {
		return (args) -> {
			repository.save(new Credentials("Jdoea", "test", "test", true));
			repository.save(new Credentials("Jdoeb", "test", "test", true));
			repository.save(new Credentials("Jdoec", "test", "test", true));
		};
	}
}
