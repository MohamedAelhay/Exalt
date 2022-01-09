package com.exalt.api.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.exalt.utils.DateUtil;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private HttpStatus status;
    private String message;
    private T data;
    private List<String> errors;

    private String timeStamp
            = DateUtil.getTimeStamp();

    public ApiResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ApiResponse(HttpStatus status, String message, T data) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public ApiResponse(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
