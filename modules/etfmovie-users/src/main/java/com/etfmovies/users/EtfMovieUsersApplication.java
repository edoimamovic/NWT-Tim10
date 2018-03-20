package com.etfmovies.users;

import com.etfmovies.users.models.ETFVideoUser;
import com.etfmovies.users.models.PersonalData;
import com.etfmovies.users.models.UserRoles;
import com.etfmovies.users.repositories.ETFVideoUserRepository;
import com.etfmovies.users.repositories.PersonalDataRepository;
import com.etfmovies.users.repositories.UserRolesRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class EtfMovieUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtfMovieUsersApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRolesRepository repository) {
		return (args) -> {
			repository.save(new UserRoles("Guest"));
			repository.save(new UserRoles("RegisteredUser"));
            repository.save(new UserRoles("TestRole1"));
		};
	}
}
