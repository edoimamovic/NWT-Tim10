package com.etfmovies.auth.controllers;

import com.etfmovies.auth.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;


}
