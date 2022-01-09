package com.exalt.api.exception;

public class CarNotAvailable extends RuntimeException {
    public CarNotAvailable(String message) {
        super(message);
    }
}
