package com.garyortiz.org.restaurantReservation.application.exception;

import com.garyortiz.org.restaurantReservation.application.lasting.EMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DemoSecurityException extends Exception{

    private final HttpStatus status;
    private final String message;

    public DemoSecurityException(EMessage eMessage){
        this.status = eMessage.getStatus();
        this.message = eMessage.getMessage();
    }

}
