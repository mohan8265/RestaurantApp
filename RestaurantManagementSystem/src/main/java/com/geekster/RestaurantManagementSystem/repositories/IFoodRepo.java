package com.geekster.RestaurantManagementSystem.repositories;

import com.geekster.RestaurantManagementSystem.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<Food, Integer> {
}
