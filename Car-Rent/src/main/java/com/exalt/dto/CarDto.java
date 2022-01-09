package com.exalt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto extends BaseDto {

    private String carModel;

    private String customerName;

    private LocalDateTime rentedFrom;

    private LocalDateTime rentedTo;
}
