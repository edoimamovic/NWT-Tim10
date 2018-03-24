package com.etfmovies.auth.service_interfaces;

import com.etfmovies.auth.models.Credentials;

public interface IAuthService {
    void login(Credentials credentials);
    void logout(Credentials credentials);
}
