package com.etfmovies.auth.service_interfaces;

import com.etfmovies.auth.models.Credentials;

public interface IAuthService {
    void login(String username, String password);
    void logout(Long userId);
}
