package com.geekster.RestaurantManagementSystem.services;

import com.geekster.RestaurantManagementSystem.models.AuthenticationToken;
import com.geekster.RestaurantManagementSystem.models.User;
import com.geekster.RestaurantManagementSystem.models.dto.SignInInput;
import com.geekster.RestaurantManagementSystem.models.dto.SignUpOutput;
import com.geekster.RestaurantManagementSystem.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthTokenService authTokenService;

    public SignUpOutput signUpUser(User user) {
        boolean signUpStatus;
        String signUpMessage = null;
        String currentEmail = user.getUserEmail();

        User existingUser = userRepo.findByUserEmail(currentEmail);

        if(existingUser != null){
            signUpStatus = false;
            signUpMessage = "user already registered";
            return new SignUpOutput(signUpStatus,signUpMessage);
        }

        String encryptedPassword = "##" + user.getUserPassword() + "##";
        user.setUserPassword(encryptedPassword);
        userRepo.save(user);
        signUpStatus = true;
        signUpMessage = "user register successfully!!!";
        return new SignUpOutput(signUpStatus,signUpMessage);
    }

    public String signInUser(SignInInput signInInput) {
        String currentEmail = signInInput.getEmail();
        User existingUser = userRepo.findByUserEmail(currentEmail);
        if(existingUser == null){
            return "signup first";
        }

        String encryptedPassword = "##" + signInInput.getPassword() + "##";
        String existingPassword = existingUser.getUserPassword();
        if(!encryptedPassword.equals(existingPassword)){
            return "wrong password";
        }

        AuthenticationToken existingToken = authTokenService.getToken(existingUser);
        if(existingToken != null){
            return "already signed in";
        }

        AuthenticationToken token = new AuthenticationToken(existingUser);
        authTokenService.addAuthToken(token);
        return "your token value is: " + token.getTokenValue();

    }

    public String signOutUser(String email, String token) {
        User existingUser = userRepo.findByUserEmail(email);
        if(existingUser == null){
            return "not a valid user";
        }
        AuthenticationToken existingToken = authTokenService.getToken(existingUser);
        if(existingToken == null){
            return "user not signed in";
        }
        AuthenticationToken existingToken1 = authTokenService.findByTokenValue(token);
        if(existingToken1 == null){
            return "invalid token value";
        }
        authTokenService.deleteToken(existingToken);
        return "sign out successfully";
    }

    public User findUserById(Integer currentUserId) {
        return userRepo.findById(currentUserId).get();
    }
}
