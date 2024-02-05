package com.garyortiz.org.restaurantReservation.application.controller;

import com.garyortiz.org.restaurantReservation.application.service.Restaurant.RestaurantGenericService;
import com.garyortiz.org.restaurantReservation.domain.dto.RestaurantDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private List<RestaurantGenericService<RestaurantDto>> restaurantServices;

    private RestaurantGenericService<RestaurantDto> getRestaurantService() {
        return restaurantServices.get(0); // Adjust index accordingly
    }

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        getRestaurantService().register(restaurantDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable("id") Object id) {
        RestaurantDto restaurantDto = getRestaurantService().findById(id);
        return restaurantDto != null ?
                new ResponseEntity<>(restaurantDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        List<RestaurantDto> restaurants = getRestaurantService().findAll();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable("id") Object id, @RequestBody RestaurantDto restaurantDto) {
        getRestaurantService().update(id, restaurantDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") Object id) {
        getRestaurantService().remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
