package com.etfmovies.users.controllers;

import com.etfmovies.users.models.UserData;
import com.etfmovies.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    public void registerUser(UserData userData){
        userService.registerUser(userData);
    }

    @RequestMapping(value = "/update")
    public void updateUserData(UserData userData){
        userService.updateUserData(userData);
    }

    @RequestMapping(value = "/activate")
    public void activateUser(@RequestParam("email") String email){
        userService.activateUser(email);
    }

    @RequestMapping(value = "/change-password")
    public void changePassword(@RequestParam("email") String email, @RequestParam("password") String password){
        userService.changePassword(email, password);
    }
}
