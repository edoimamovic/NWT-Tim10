package com.etfmovies.auth.controllers;

import com.etfmovies.auth.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
    public void login(@RequestParam("username") String username, @RequestParam("password") String password){
        authService.login(username, password);
    }

    @RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
    public void logout(@RequestParam("userid") Long userid){
        authService.logout(userid);
    }
}
