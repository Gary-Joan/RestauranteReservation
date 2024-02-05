package com.garyortiz.org.restaurantReservation.domain.dto;


public record AuthenticationDto(
        String email,
        String password
) {
}
