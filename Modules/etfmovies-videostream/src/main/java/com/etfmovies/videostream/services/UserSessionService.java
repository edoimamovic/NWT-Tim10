package com.etfmovies.videostream.services;

import com.etfmovies.videostream.models.UserSession;
import com.etfmovies.videostream.repositories.UserSessionRepository;
import com.etfmovies.videostream.service_interfaces.IUserSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.AuthMessage;

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