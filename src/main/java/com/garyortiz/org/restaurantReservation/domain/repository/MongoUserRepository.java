package com.garyortiz.org.restaurantReservation.domain.repository;
import com.garyortiz.org.restaurantReservation.domain.entity.mongo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoUserRepository extends MongoRepository<User, Object> {
}