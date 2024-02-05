package com.garyortiz.org.restaurantReservation.domain.repository;

import com.garyortiz.org.restaurantReservation.domain.entity.mongo.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRestaurantRepository extends MongoRepository<Restaurant, String> {
}
