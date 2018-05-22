package com.etfmovies.videostream.service_interfaces;

import utils.AuthMessage;

public interface IUserSessionService {
    public boolean isUserLoggedIn(String token);
    public void userLogOn(AuthMessage message);
    public void userLogOff(AuthMessage message);
}

