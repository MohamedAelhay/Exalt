package com.exalt.utils;

import com.exalt.model.Car;
import com.exalt.dto.CarDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataMapperUtil {

    private ModelMapper modelMapper;

    DataMapperUtil() {
        this.modelMapper = new ModelMapper();
    }

    public CarDto convertToDto(Car car){
        return modelMapper.map(car, CarDto.class);
    }

    public Car convertToEntity(CarDto carDto) {
        return modelMapper.map(carDto, Car.class);
    }
}
