package com.geekster.RestaurantManagementSystem.services;

import com.geekster.RestaurantManagementSystem.models.AuthenticationToken;
import com.geekster.RestaurantManagementSystem.models.User;
import com.geekster.RestaurantManagementSystem.repositories.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {
    @Autowired
    IAuthTokenRepo authTokenRepo;

    public void addAuthToken(AuthenticationToken token) {
        authTokenRepo.save(token);
    }

    public AuthenticationToken getToken(User existingUser) {
        return authTokenRepo.findByUser(existingUser);
    }

    public void deleteToken(AuthenticationToken existingToken) {
        authTokenRepo.delete(existingToken);
    }

    public AuthenticationToken findByTokenValue(String token) {
        return authTokenRepo.findByTokenValue(token);
    }
}
