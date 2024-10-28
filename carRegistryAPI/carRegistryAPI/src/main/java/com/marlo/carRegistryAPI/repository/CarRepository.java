package com.marlo.carRegistryAPI.repository;

import com.marlo.carRegistryAPI.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
