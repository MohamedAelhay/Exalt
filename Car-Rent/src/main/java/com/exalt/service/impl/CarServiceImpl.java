package com.exalt.service.impl;

import com.exalt.model.Car;
import com.exalt.dto.CarDto;
import com.exalt.service.CarService;
import com.exalt.utils.DataMapperUtil;
import com.exalt.repository.CarRepository;
import com.exalt.api.exception.CarNotAvailable;
import com.exalt.api.exception.NotFoundException;
import com.exalt.api.exception.CarModelNameNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.security.InvalidParameterException;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    protected DataMapperUtil dataMapperUtil;

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarDto create(CarDto carDto) {
        if(carDto.getCarModel() == null) {
            throw new CarModelNameNotFound();
        }

        Car newCar = carRepository.save(this.dataMapperUtil.convertToEntity(carDto));

        return this.dataMapperUtil.convertToDto(newCar);
    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(this.dataMapperUtil::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getAvailableCars() {
        return carRepository
                .getAvailableCars(LocalDateTime.now())
                .stream()
                .map(this.dataMapperUtil::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDto getCarById(Long id) {
        Car car = getCar(id);

        return this.dataMapperUtil.convertToDto(car);
    }

    @Override
    public CarDto update(CarDto carDto) {
        if(carDto.getId() == null) {
            throw new InvalidParameterException("Operation failed. Car ID can't be NULL");
        }

        Car car = getCar(carDto.getId());

        if(carDto.getCustomerName() != null) {
            car.setCustomerName(carDto.getCustomerName());
        }

        if(carDto.getCarModel() != null) {
            car.setCarModel(carDto.getCarModel());
        }

        if(carDto.getRentedFrom() != null && carDto.getRentedTo() != null) {
            if(carDto.getRentedFrom().isAfter(carDto.getRentedTo())) {
                throw new InvalidParameterException("Operation failed. Rent start date can not after rent end date");
            }
            car.setRentedTo(carDto.getRentedTo());
            car.setRentedFrom(carDto.getRentedFrom());
        }

        return update(car);
    }

    @Override
    public String delete(Long id) {
        Car car = getCar(id);

        carRepository.delete(car);

        return "Car with ID: " + id + " has been deleted successfully";
    }

    @Override
    public CarDto rentCar(CarDto carDto) {

        if(carDto.getId() == null
        || carDto.getRentedTo() == null
        || carDto.getRentedFrom() == null
        || carDto.getCustomerName() == null) {
            throw new InvalidParameterException("Operation failed. Car ID, Customer Name, Rent Date from and Rent Date to can't be NULL");
        }

        if(carDto.getRentedFrom().isAfter(carDto.getRentedTo())) {
            throw new InvalidParameterException("Operation failed. Rent start date can not after rent end date");
        }

        Car car = getCar(carDto.getId());

        if(car.getRentedFrom() == null && car.getRentedTo() == null) {
            car.setCustomerName(carDto.getCustomerName());
            car.setRentedFrom(carDto.getRentedFrom());
            car.setRentedTo(carDto.getRentedTo());
        } else {
            throw new CarNotAvailable("Can't Rent Car with ID: " + car.getId());
        }

        return update(car);
    }

    @Override
    public void freedRentCarExpiryDate() {
        List<Car> carList = carRepository.getRentExpiry(LocalDateTime.now());

        carList.forEach(car -> {
            car.setCustomerName(null);
            car.setRentedFrom(null);
            car.setRentedTo(null);
        });

        carRepository.saveAll(carList);
    }

    private Car getCar(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Car with ID: " + id));
    }

    private CarDto update(Car car) {
        return this.dataMapperUtil.convertToDto(carRepository.save(car));
    }
}
