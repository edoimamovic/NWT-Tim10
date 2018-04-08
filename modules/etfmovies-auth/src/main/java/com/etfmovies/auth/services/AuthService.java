package com.etfmovies.auth.services;

import com.etfmovies.auth.models.Credentials;
import com.etfmovies.auth.service_interfaces.IAuthService;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topicExchange;

    @Autowired
    public AuthService(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    @Override
    public void login(String username, String password) {
        Credentials credentials = new Credentials(username, password, "12345");

        String routingKey = "auth.user_logged_in";
        String message = "User logged in: " + username + " : " + password;
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, message);
    }

    @Override
    public void logout(Long userId) {

    }
}