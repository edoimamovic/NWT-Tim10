package com.etfmovies.users.services;

import com.etfmovies.users.models.UserSession;
import com.etfmovies.users.repositories.UserSessionRepository;
import com.etfmovies.users.service_interfaces.IUserSessionService;
import com.etfmovies.users.utils.AuthMessage;
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
