package com.garyortiz.org.restaurantReservation.domain.repository;

import com.garyortiz.org.restaurantReservation.domain.entity.mongo.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoBookingRepository extends MongoRepository<Booking, String> {
}
