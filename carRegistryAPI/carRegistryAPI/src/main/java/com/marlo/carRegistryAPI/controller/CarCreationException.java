package com.marlo.carRegistryAPI.controller;

// Exception para 500
public class CarCreationException extends RuntimeException {
    public CarCreationException(String message) {
        super(message);
    }
}