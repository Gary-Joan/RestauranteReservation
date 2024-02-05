package com.garyortiz.org.restaurantReservation.domain.repository;

import com.garyortiz.org.restaurantReservation.domain.entity.mongo.TableR;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoTableRepository extends MongoRepository<TableR, String> {
}
