package com.exalt.job;

import lombok.extern.log4j.Log4j2;
import com.exalt.service.CarService;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Log4j2
@Component
public class ScheduleRentExpiry {

    @Autowired
    private CarService carService;

    @Scheduled(cron = "${jobs.rent.expiry}", zone = "GMT")
    public void freeRentExpiryCars() {
        log.info("cron job started at " + LocalDateTime.now());
        carService.freedRentCarExpiryDate();
        log.info("cron job ended at " + LocalDateTime.now());
    }
}
