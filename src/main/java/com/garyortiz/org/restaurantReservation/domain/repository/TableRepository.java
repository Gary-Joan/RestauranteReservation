package com.garyortiz.org.restaurantReservation.domain.repository;

import com.garyortiz.org.restaurantReservation.domain.entity.jpa.TableR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository  extends JpaRepository<TableR, Long> {
}