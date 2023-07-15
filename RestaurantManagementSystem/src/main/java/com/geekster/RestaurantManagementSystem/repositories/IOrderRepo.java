package com.geekster.RestaurantManagementSystem.repositories;

import com.geekster.RestaurantManagementSystem.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order, Integer> {
}
