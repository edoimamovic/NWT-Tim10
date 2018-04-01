package com.etfmovies.users.controllers;

import com.etfmovies.users.models.UserData;
import com.etfmovies.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerUser(UserData userData){
        userService.registerUser(userData);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateUserData(UserData userData){
        userService.updateUserData(userData);
    }

    @RequestMapping(value = "/get-info", method = RequestMethod.GET)
    public UserData getUserData(@RequestParam("id") Long id){
        return userService.getUserDataByUserId(id);
    }

    @RequestMapping(value = "/activate", method = RequestMethod.POST)
    public void activateUser(@RequestParam("email") String email){
        userService.activateUser(email);
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.PUT)
    public void changePassword(@RequestParam("email") String email, @RequestParam("password") String password){
        userService.changePassword(email, password);
    }


}
