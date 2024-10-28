package com.marlo.carRegistryAPI.controller;

// Exception para 404
public class CarNotFoundException extends RuntimeException {
    public CarNotFoundException(String message) {
        super(message);
    }
}
