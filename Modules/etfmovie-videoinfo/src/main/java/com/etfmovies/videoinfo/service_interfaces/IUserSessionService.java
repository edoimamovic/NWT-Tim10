package com.etfmovies.videoinfo.service_interfaces;

import com.etfmovies.videoinfo.utils.AuthMessage;

public interface IUserSessionService {
    public boolean isUserLoggedIn(String token);
    public void userLogOn(AuthMessage message);
    public void userLogOff(AuthMessage message);
}
