package com.etfmovies.users.auth;

import com.etfmovies.users.services.UserSessionService;
import com.etfmovies.users.utils.AuthMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthEventSubscriber {
    private Logger logger = LoggerFactory.getLogger(AuthEventSubscriber.class);

    @Autowired
    UserSessionService userSessionService;

    @RabbitListener(queues = "auth-queue")
    public void receive(String message) {
        AuthMessage authMessage = AuthMessage.fromJSONString(message);
        userSessionService.userLogOn(authMessage);

        logger.info("Received message '{}', '{}'", authMessage.getEmail(), authMessage.getToken());
    }
}