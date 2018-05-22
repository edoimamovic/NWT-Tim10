package com.etfmovies.auth.security;


import com.etfmovies.auth.utils.AuthMessage;
import com.etfmovies.auth.models.ApplicationUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.etfmovies.auth.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    private RabbitTemplate rabbitTemplate;
    private TopicExchange topicExchange;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        this.authenticationManager = authenticationManager;
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            ApplicationUser creds = new ObjectMapper().readValue(req.getInputStream(), ApplicationUser.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getEmail(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();

        notifyUserLogin(token, ((User) auth.getPrincipal()).getUsername());
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }

    private void notifyUserLogin(String token, String username) {
        String routingKey = "auth.user_logged_in";

        AuthMessage message = new AuthMessage(username, token);
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, message.toJSONString());
    }

}