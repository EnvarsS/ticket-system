package org.envycorp.bookingservice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String,String> handleIllegalArgumentException(IllegalArgumentException ex){
        return Map.of("error", ex.getMessage());
    }
}
