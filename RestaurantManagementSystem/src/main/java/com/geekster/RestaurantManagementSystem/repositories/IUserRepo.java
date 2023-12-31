package com.geekster.RestaurantManagementSystem.repositories;

import com.geekster.RestaurantManagementSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
    User findByUserEmail(String currentEmail);
}
