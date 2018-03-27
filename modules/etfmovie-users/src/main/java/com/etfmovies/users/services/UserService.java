package com.etfmovies.users.services;

import com.etfmovies.users.models.UserData;
import com.etfmovies.users.repositories.UserDataRepository;
import com.etfmovies.users.service_interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    public void registerUser(UserData userData) {
        userDataRepository.save(userData);
    }

    @Override
    public UserData getUserDataByUserId(Long userId) {
        return userDataRepository.findById(userId).get();
    }

    @Override
    public void updateUserData(UserData userData) {
        userDataRepository.save(userData);
    }

    @Override
    public void activateUser(String email) {
        UserData userData = userDataRepository.findByEmail(email);
        userData.setActive(true);
        userDataRepository.save(userData);
    }

    @Override
    public void changePassword(String email, String password) {
        UserData userData = userDataRepository.findByEmail(email);
        userData.setPassword(password);
        userDataRepository.save(userData);
    }
}
