package com.garyortiz.org.restaurantReservation.application.controller;

import com.garyortiz.org.restaurantReservation.application.exception.DemoSecurityException;
import com.garyortiz.org.restaurantReservation.application.service.User.JpaUserService;
import com.garyortiz.org.restaurantReservation.domain.dto.AuthenticationDto;
import com.garyortiz.org.restaurantReservation.domain.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public record AuthenticationController(
        JpaUserService authenticationService
) {

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto){
        String token = authenticationService.register(userDto);
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDto authenticationDto) throws DemoSecurityException {
        String token = authenticationService.login(authenticationDto);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
