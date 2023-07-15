package com.geekster.RestaurantManagementSystem.services;

import com.geekster.RestaurantManagementSystem.models.Food;
import com.geekster.RestaurantManagementSystem.models.Order;
import com.geekster.RestaurantManagementSystem.models.User;
import com.geekster.RestaurantManagementSystem.repositories.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;

    @Autowired
    UserService userService;

    @Autowired
    FoodService foodService;

    public String addOrder(Order order) {
        User currentUser = order.getUser();
        Integer currentUserId = currentUser.getUserId();

        User existingUser = userService.findUserById(currentUserId);
        if(existingUser == null){
            return "not a valid user";
        }

        List<Food> foodList = order.getFood();
        for(Food food:foodList){
            Integer id = food.getFoodId();
            if(foodService.getFoodById(id) == null){
                return food.getFoodTitle() + " not available";
            }
        }

        orderRepo.save(order);
        return "order received";
    }

    public String cancelOrder(Integer id) {
        Order order = orderRepo.findById(id).get();
        if(order == null){
            return "not a valid order";
        }

        User currentUser = order.getUser();
        Integer currentUserId = currentUser.getUserId();

        User existingUser = userService.findUserById(currentUserId);
        if(existingUser == null){
            return "not a valid user";
        }

        orderRepo.delete(order);
        return "order canceled";
    }
}
