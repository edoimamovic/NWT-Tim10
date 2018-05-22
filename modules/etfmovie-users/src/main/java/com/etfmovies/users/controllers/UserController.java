package com.etfmovies.users.controllers;

import com.etfmovies.users.models.UserData;
import com.etfmovies.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity registerUser(@RequestBody UserData userData){
        try{
            return ResponseEntity.ok(userService.registerUser(userData));
        }
        catch (ConstraintViolationException ex){
            return new ResponseEntity("All properties must be provided.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateUserData(@RequestBody UserData userData){
        try{
            return ResponseEntity.ok(userService.updateUserData(userData));
        }
        catch (Exception ex){
            return new ResponseEntity("User data is not valid.", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/get-info", method = RequestMethod.GET)
    public UserData getUserData(@RequestParam("id") Long id){
        return userService.getUserDataByUserId(id);
    }

    @RequestMapping(value = "/activate", method = RequestMethod.PUT)
    public ResponseEntity activateUser(@RequestParam("email") String email){
        if (email == null ||email.isEmpty()){
            return new ResponseEntity("Email must be provided.", HttpStatus.BAD_REQUEST);
        }
        userService.activateUser(email);
        return new ResponseEntity("All properties must be provided.", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.PUT)
    public ResponseEntity changePassword(@RequestParam("email") String email, @RequestParam("password") String password){
        if (email == null || email.isEmpty() || password == null || password.isEmpty()){
            return new ResponseEntity("Email and password must be provided", HttpStatus.BAD_REQUEST);
        }

        userService.changePassword(email, password);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
