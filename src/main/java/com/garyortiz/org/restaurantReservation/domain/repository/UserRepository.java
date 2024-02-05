package com.garyortiz.org.restaurantReservation.domain.repository;

import com.garyortiz.org.restaurantReservation.domain.entity.jpa.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
