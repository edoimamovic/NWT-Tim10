package com.etfmovies.auth;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableDiscoveryClient
@SpringBootApplication
public class EtfMoviesAuthApplication {

    @Value("${spring.topicexchange.name}")
    private String topicExchangeName;

	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(EtfMoviesAuthApplication.class, args);
	}
}
