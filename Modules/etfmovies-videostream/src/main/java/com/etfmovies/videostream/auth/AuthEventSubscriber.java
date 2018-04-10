package com.etfmovies.videostream.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class AuthEventSubscriber {
    private Logger logger = LoggerFactory.getLogger(AuthEventSubscriber.class);

    @RabbitListener(queues = "auth-queue")
    public void receive(String message) {
        logger.info("Received message '{}'", message);
    }
}