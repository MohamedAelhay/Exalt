package com.exalt.model;

import lombok.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "car")
public class Car extends BaseEntity {

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "rented_from")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime rentedFrom;

    @Column(name = "rented_to")
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    private LocalDateTime rentedTo;
}
