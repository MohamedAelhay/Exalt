package com.exalt.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

import static com.exalt.api.response.ApiResponseHelper.*;


@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler
    public ResponseEntity handleException(Exception exception){
        return BadRequestApiResponse(exception.getMessage(), Collections.singletonList(exception.getLocalizedMessage()));
    }

    @ExceptionHandler
    public ResponseEntity handleException(NotFoundException notFoundException){
        return NotFound("Can't Find " + notFoundException.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity handleException(CarModelNameNotFound carModelNameNotFound){
        return InValid("Please Enter Car Model");
    }

    @ExceptionHandler
    public ResponseEntity handleException(CarNotAvailable carNotAvailable){
        return CarNotAvailable(carNotAvailable.getMessage());
    }
}
