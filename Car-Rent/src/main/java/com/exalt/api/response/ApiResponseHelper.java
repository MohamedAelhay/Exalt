package com.exalt.api.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ApiResponseHelper {
    public static <T> ResponseEntity OKApiResponse(T data) {
        return new ResponseEntity(new ApiResponse(HttpStatus.OK, "Operation was successful", data), HttpStatus.OK);
    }

    public static ResponseEntity BadRequestApiResponse(String message, List<String> errors) {
        return new ResponseEntity(new ApiResponse(HttpStatus.BAD_REQUEST, message, errors), HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity CarNotAvailable(String message) {
        return new ResponseEntity(new ApiResponse(HttpStatus.CONFLICT, message), HttpStatus.CONFLICT);
    }

    public static ResponseEntity NotFound(String message) {
        return new ResponseEntity(new ApiResponse(HttpStatus.NOT_FOUND, message), HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity InValid(String message) {
        return new ResponseEntity(new ApiResponse(HttpStatus.NOT_ACCEPTABLE, message), HttpStatus.NOT_ACCEPTABLE);
    }
}
