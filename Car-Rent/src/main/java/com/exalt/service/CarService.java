package com.exalt.service;

import com.exalt.dto.CarDto;

import java.util.List;

public interface CarService {
    CarDto create(CarDto carDto);

    List<CarDto> getAllCars();

    List<CarDto> getAvailableCars();

    CarDto getCarById(Long id);

    CarDto update(CarDto carDto);

    String delete(Long id);

    CarDto rentCar(CarDto carDto);

    void freedRentCarExpiryDate();
}
