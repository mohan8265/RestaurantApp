package com.geekster.RestaurantManagementSystem.controllers;

import com.geekster.RestaurantManagementSystem.models.Order;
import com.geekster.RestaurantManagementSystem.services.OrderService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public String addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
    @DeleteMapping("/orders/{id}")
    public String cancelOrder(@PathVariable Integer id){
        return orderService.cancelOrder(id);
    }
}
