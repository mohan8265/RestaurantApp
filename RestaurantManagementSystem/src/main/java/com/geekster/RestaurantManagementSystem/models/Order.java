package com.geekster.RestaurantManagementSystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordertable")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer foodQuantity;

    @Enumerated(value = EnumType.STRING)
    private Status foodStatus;


    @ManyToOne
    private User user;

    @ManyToMany
    private List<Food> food;



}
