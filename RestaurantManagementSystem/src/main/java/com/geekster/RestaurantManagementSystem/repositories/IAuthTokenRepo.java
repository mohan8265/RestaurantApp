package com.geekster.RestaurantManagementSystem.repositories;

import com.geekster.RestaurantManagementSystem.models.AuthenticationToken;
import com.geekster.RestaurantManagementSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findByUser(User existingUser);

    AuthenticationToken findByTokenValue(String token);
}
