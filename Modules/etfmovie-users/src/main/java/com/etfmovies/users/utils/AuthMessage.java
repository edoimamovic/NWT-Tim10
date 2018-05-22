package com.etfmovies.users.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AuthMessage {
    private String email;
    private String token;

    public AuthMessage() {
    }

    public AuthMessage(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String toJSONString() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }

    public static AuthMessage fromJSONString(String data) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(data, AuthMessage.class);
        } catch (IOException e) {
            return null;
        }
    }
}
