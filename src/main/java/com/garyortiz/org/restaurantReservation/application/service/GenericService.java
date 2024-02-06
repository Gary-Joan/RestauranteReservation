package com.garyortiz.org.restaurantReservation.application.service;

import java.util.List;

public interface GenericService<Dto> {
    String register(Dto dto);
    void update(Object id, Dto dto);
    Dto findById(Object id);
    List<Dto> findAll();
    void remove(Object id);
}