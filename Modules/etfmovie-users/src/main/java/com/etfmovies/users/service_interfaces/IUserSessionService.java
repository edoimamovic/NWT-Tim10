package com.etfmovies.users.service_interfaces;

import com.etfmovies.users.utils.AuthMessage;

public interface IUserSessionService {
    public boolean isUserLoggedIn(String token);
    public void userLogOn(AuthMessage message);
    public void userLogOff(AuthMessage message);
}
