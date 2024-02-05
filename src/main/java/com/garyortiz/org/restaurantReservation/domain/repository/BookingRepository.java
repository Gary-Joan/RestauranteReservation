package com.garyortiz.org.restaurantReservation.domain.repository;

import com.garyortiz.org.restaurantReservation.domain.entity.jpa.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}