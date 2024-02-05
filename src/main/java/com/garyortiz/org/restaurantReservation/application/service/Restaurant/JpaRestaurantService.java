package com.garyortiz.org.restaurantReservation.application.service.Restaurant;

import com.garyortiz.org.restaurantReservation.domain.dto.RestaurantDto;

import java.util.List;

public class JpaRestaurantService implements RestaurantGenericService<RestaurantDto> {
    @Override
    public void register(RestaurantDto restaurantDto) {

    }

    @Override
    public void update(Object id, RestaurantDto restaurantDto) {

    }

    @Override
    public RestaurantDto findById(Object id) {
        return null;
    }

    @Override
    public List<RestaurantDto> findAll() {
        return null;
    }

    @Override
    public void remove(Object id) {

    }
}
