package com.etfmovies.auth;

import com.etfmovies.auth.models.Credentials;
import com.etfmovies.auth.repositories.CredentialsRepository;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class EtfMoviesAuthApplication {

    @Value("${spring.topicexchange.name}")
    private String topicExchangeName;

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange(topicExchangeName);
	}

	public static void main(String[] args) {
		SpringApplication.run(EtfMoviesAuthApplication.class, args);
	}
}
