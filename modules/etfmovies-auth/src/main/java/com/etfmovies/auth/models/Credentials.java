package com.etfmovies.auth.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    @NotNull
    private String token;

    @NotNull
    private Boolean isActive;

    public Credentials(@NotNull String userName, @NotNull String password, @NotNull String token, @NotNull Boolean isActive) {
        this.userName = userName;
        this.password = password;
        this.token = token;
        this.isActive = isActive;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
