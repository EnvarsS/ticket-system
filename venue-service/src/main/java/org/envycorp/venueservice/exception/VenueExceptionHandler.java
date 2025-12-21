package org.envycorp.venueservice.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class VenueExceptionHandler {

    @ExceptionHandler(VenueNotFoundException.class)
    public Map<String, String> handleVenueNotFoundException(VenueNotFoundException ex) {
        return Map.of("error", ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        HashMap<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(
                (error) -> errors.put(error.getField(), error.getDefaultMessage())
        );
        return errors;
    }
}
