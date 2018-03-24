package com.etfmovies.users.service_interfaces;

import com.etfmovies.users.models.UserData;

public interface IUserService {
    void registerUser(UserData userData);
    void updateUserData(UserData userData);
    void activateUser(String email);
    void changePassword(String email, String password);
}
