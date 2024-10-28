package com.marlo.carRegistryAPI.controller;

import com.marlo.carRegistryAPI.entity.Car;
import com.marlo.carRegistryAPI.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id) {
        System.out.println("Hi");
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new CarNotFoundException("Car not found with id: " + id));
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        try {
            Car addedCar = service.save(car);
            return ResponseEntity.ok().body(addedCar);
        } catch (Exception e) {
            throw new CarCreationException("Fail to create car");
        }
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id, @RequestBody Car car) {
        Car updatedCar = service.update(id, car);

        if (updatedCar != null) {
            return ResponseEntity.ok().body(updatedCar);
        } else {
            throw new CarNotFoundException("Car not found with id: " + id);
        }
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable int id) {
        boolean isDeleted = service.delete(id);

        if (isDeleted) {
            return ResponseEntity.ok().body("Car deleted successfully");
        } else {
            throw new CarNotFoundException("Car not found with id: " + id);
        }
    }
}
