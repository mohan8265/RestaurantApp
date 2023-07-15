package com.geekster.RestaurantManagementSystem.controllers;

import com.geekster.RestaurantManagementSystem.models.User;
import com.geekster.RestaurantManagementSystem.models.dto.SignInInput;
import com.geekster.RestaurantManagementSystem.models.dto.SignUpOutput;
import com.geekster.RestaurantManagementSystem.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignUpOutput signUpUser(@RequestBody @Valid User user){
        return userService.signUpUser(user);
    }
    @PostMapping("/signin")
    public String signInUser(@RequestBody SignInInput signInInput){
        return userService.signInUser(signInInput);
    }
    @DeleteMapping("/signout")
    public String signOutUser(@RequestParam String email,@RequestParam String token){
        return userService.signOutUser(email,token);
    }
}
