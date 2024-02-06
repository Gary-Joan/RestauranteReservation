package com.garyortiz.org.restaurantReservation.application.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class DemoSecurityExceptionHandler {

    @ExceptionHandler(DemoSecurityException.class)
    public ResponseEntity<?> handleDemoSecurityException(DemoSecurityException exception,
                                                         WebRequest request){
        ExceptionResponse response = new ExceptionResponse(exception.getMessage());
        return new ResponseEntity<>(response, exception.getStatus());
    }

}
