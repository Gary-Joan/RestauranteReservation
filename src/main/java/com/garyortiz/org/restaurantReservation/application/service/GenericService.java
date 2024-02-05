package com.garyortiz.org.restaurantReservation.application.service;

import java.util.List;

public interface GenericService<Dto> {
    void register(Dto dto);
    void update(Long id, Dto dto);
    Dto findById(Long id);
    List<Dto> findAll();
    void remove(Long id);
}