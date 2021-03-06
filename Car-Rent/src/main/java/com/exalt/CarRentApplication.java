package com.exalt;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication
public class CarRentApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarRentApplication.class, args);
    }
}
