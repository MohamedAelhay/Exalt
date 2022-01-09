package com.exalt.repository;

import com.exalt.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CarRepository extends JpaRepository<Car,Long> {
    @Query("SELECT car FROM Car car where car.rentedFrom > :date OR car.rentedTo < :date OR car.rentedTo = NULL")
    List<Car> getAvailableCars(@Param("date") LocalDateTime dateTime);

    @Query("SELECT car FROM Car car where car.rentedTo < :date")
    List<Car> getRentExpiry(@Param("date") LocalDateTime dateTime);
}
