package com.etfmovies.auth.controllers;

import com.etfmovies.auth.models.ApplicationUser;
import com.etfmovies.auth.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/auth-data")
class AuthDataController {
    @Autowired
    ApplicationUserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/change-password", method = RequestMethod.PUT)
    public ResponseEntity changePassword(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("newPassword") String newPassword) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty() || newPassword == null || newPassword.isEmpty()) {
            return new ResponseEntity("Email and password must be provided", HttpStatus.BAD_REQUEST);
        }

        String hash = bCryptPasswordEncoder.encode(password);

        String newHash = bCryptPasswordEncoder.encode(newPassword);
        ApplicationUser userData = repository.findByEmail(email);

        if (!bCryptPasswordEncoder.matches(password, userData.getPassword())) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        userData.setPassword(newHash);
        repository.save(userData);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}