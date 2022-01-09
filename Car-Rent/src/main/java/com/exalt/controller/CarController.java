package com.exalt.controller;

import com.exalt.dto.CarDto;
import com.exalt.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.exalt.api.response.ApiResponseHelper.OKApiResponse;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity index() {
        return OKApiResponse(carService.getAllCars());
    }

    @GetMapping("/available")
    public ResponseEntity availableCars() {
        return OKApiResponse(carService.getAvailableCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarById(@PathVariable("id") Long id) {
        return OKApiResponse(carService.getCarById(id));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CarDto carDto) {
        return OKApiResponse(carService.create(carDto));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody CarDto carDto) {
        return OKApiResponse(carService.update(carDto));
    }

    @PatchMapping
    public ResponseEntity rentCar(@RequestBody CarDto carDto) {
        return OKApiResponse(carService.rentCar(carDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        return OKApiResponse(carService.delete(id));
    }

}
