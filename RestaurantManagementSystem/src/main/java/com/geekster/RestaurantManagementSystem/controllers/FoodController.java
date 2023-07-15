package com.geekster.RestaurantManagementSystem.controllers;

import com.geekster.RestaurantManagementSystem.models.Food;
import com.geekster.RestaurantManagementSystem.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;

    @PostMapping("/food/{adminEmail}")
    public String addFood(@PathVariable String adminEmail,@RequestBody Food food){
        return foodService.addFood(adminEmail,food);
    }
    @GetMapping("/foods")
    public List<Food> foodMenu(){
        return foodService.foodMenu();
    }
    @PutMapping("/food/{adminEmail}/{id}")
    public String updateFoodById(@PathVariable String adminEmail,@PathVariable Integer id,@RequestBody Food food){
        return foodService.updateFoodById(adminEmail,id,food);
    }
    @DeleteMapping("/food/{adminEmail}/{id}")
    public String deleteFoodBYId(@PathVariable String adminEmail,@PathVariable Integer id){
        return foodService.deleteFoodById(adminEmail,id);
    }

}
