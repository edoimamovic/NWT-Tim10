package com.etfmovies.users;

import com.etfmovies.users.models.Role;
import com.etfmovies.users.repositories.RolesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EtfMovieUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtfMovieUsersApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(RolesRepository repository) {
		return (args) -> {
			repository.save(new Role("Guest", "Test Description"));
			repository.save(new Role("RegisteredUser", "Test Description"));
            repository.save(new Role("TestRole1", "Test Description"));
		};
	}
}
