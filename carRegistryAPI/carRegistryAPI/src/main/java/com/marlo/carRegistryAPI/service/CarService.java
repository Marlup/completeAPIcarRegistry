package com.marlo.carRegistryAPI.service;

import com.marlo.carRegistryAPI.entity.Car;
import com.marlo.carRegistryAPI.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository repository;

    public Car save(Car car) {
        return repository.save(car);
    }

    public boolean delete(int id) {
        Optional<Car> car = repository.findById(id);
        if (car.isPresent()) {
            repository.delete(car.get());
            return true;
        }
        return false;
    }

    public Car update(int id, Car car) {
        Optional<Car> carFromTable = repository.findById(id);

        if (carFromTable.isPresent()) {
            car.setId(id);
            return repository.save(car);
        } else {
            return null;
        }
    }

    public Optional<Car> findById(int id) {
        return repository.findById(id);
    }
}
