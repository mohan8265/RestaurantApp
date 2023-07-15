package com.geekster.RestaurantManagementSystem.services;

import com.geekster.RestaurantManagementSystem.models.Food;
import com.geekster.RestaurantManagementSystem.repositories.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo foodRepo;

    public List<Food> foodMenu() {
        return foodRepo.findAll();
    }

    public String addFood(String adminEmail, Food food) {
        int idx = 0;
        for(int i=adminEmail.length()-1;i>=0;i--){
            if(adminEmail.charAt(i) == '@'){
                idx = i;
                break;
            }
        }

        String str = "";
        str = adminEmail.substring(idx);
        if(!str.equals("@admin.com")){
            return "not a valid person";
        }

        foodRepo.save(food);
        return "food added";
    }

    public String updateFoodById(String adminEmail,Integer id,  Food food) {
        int idx = 0;
        for(int i=adminEmail.length()-1;i>=0;i--){
            if(adminEmail.charAt(i) == '@'){
                idx = i;
                break;
            }
        }

        String str = "";
        str = adminEmail.substring(idx);
        if(!str.equals("@admin.com")){
            return "not a valid person";
        }

        food.setFoodId(id);
        foodRepo.save(food);
        return "food updated";
    }

    public String deleteFoodById(String adminEmail, Integer id) {
        int idx = 0;
        for(int i=adminEmail.length()-1;i>=0;i--){
            if(adminEmail.charAt(i) == '@'){
                idx = i;
                break;
            }
        }

        String str = "";
        str = adminEmail.substring(idx);
        if(!str.equals("@admin.com")){
            return "not a valid person";
        }

        foodRepo.deleteById(id);
        return "food deleted";
    }

    public Food getFoodById(Integer id) {
        return foodRepo.findById(id).get();
    }
}
