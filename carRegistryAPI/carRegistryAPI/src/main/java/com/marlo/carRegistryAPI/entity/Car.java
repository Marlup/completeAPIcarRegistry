package com.marlo.carRegistryAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue
    private int id;
    
    private String brand;
    private String model;
    
    private Integer milleage;
    
    private Double price;
    
    private Integer car_year;
    
    private String description;
    private String colour;
    private String fuelType;

    private Integer numDoors;
}