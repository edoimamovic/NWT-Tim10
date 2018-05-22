package com.etfmovies.videoinfo.services;

import com.etfmovies.videoinfo.models.UserSession;
import com.etfmovies.videoinfo.repositories.UserSessionRepository;
import com.etfmovies.videoinfo.service_interfaces.IUserSessionService;
import com.etfmovies.videoinfo.utils.AuthMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSessionService implements IUserSessionService {
    @Autowired
    private UserSessionRepository userSessionRepository;

    @Override
    public boolean isUserLoggedIn(String token) {
        UserSession userSession = userSessionRepository.findByToken(token);
        return userSession != null;
    }

    @Override
    public void userLogOn(AuthMessage message) {
        UserSession userSession = new UserSession(message.getEmail(), message.getToken());
        userSessionRepository.save(userSession);
    }

    @Override
    public void userLogOff(AuthMessage message) {
        UserSession userSession = userSessionRepository.findByEmail(message.getEmail());
        userSessionRepository.delete(userSession);
    }
}
