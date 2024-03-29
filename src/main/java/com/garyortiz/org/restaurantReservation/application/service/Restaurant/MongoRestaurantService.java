package com.garyortiz.org.restaurantReservation.application.service.Restaurant;

import com.garyortiz.org.restaurantReservation.domain.dto.RestaurantDto;
import com.garyortiz.org.restaurantReservation.domain.entity.mongo.Restaurant;
import com.garyortiz.org.restaurantReservation.domain.repository.MongoRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MongoRestaurantService implements RestaurantGenericService<RestaurantDto> {

    @Autowired
    private MongoRestaurantRepository restaurantRepository;

    @Override
    public String register(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setNombre(restaurantDto.getName());
        restaurant.setDireccion(restaurantDto.getAddress());
        restaurant.setTelefono(restaurantDto.getPhoneNumber());
        restaurant.setHorarioApertura(restaurantDto.getOpeningHours());
        restaurant.setHorarioCierre(restaurantDto.getClosingHours());

        restaurantRepository.save(restaurant);
        return "";
    }

    @Override
    public void update(Object id, RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantRepository.findById((String) id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        // Actualiza los campos del restaurante
        restaurant.setNombre(restaurantDto.getName());
        restaurant.setDireccion(restaurantDto.getAddress());
        restaurant.setTelefono(restaurantDto.getPhoneNumber());
        restaurant.setHorarioApertura(restaurantDto.getOpeningHours());
        restaurant.setHorarioCierre(restaurantDto.getClosingHours());

        restaurantRepository.save(restaurant);
    }

    @Override
    public RestaurantDto findById(Object id) {
        Restaurant restaurant = restaurantRepository.findById((String) id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
        return convertToDto(restaurant);
    }

    @Override
    public List<RestaurantDto> findAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return convertToDtoList(restaurants);
    }

    @Override
    public void remove(Object id) {
        restaurantRepository.deleteById((String) id);
    }

    private RestaurantDto convertToDto(Restaurant restaurant) {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setName(restaurant.getNombre());
        restaurantDto.setAddress(restaurant.getDireccion());
        restaurantDto.setPhoneNumber(restaurant.getTelefono());
        restaurantDto.setOpeningHours(restaurant.getHorarioApertura());
        restaurantDto.setClosingHours(restaurant.getHorarioCierre());

        return restaurantDto;
    }

    private List<RestaurantDto> convertToDtoList(List<Restaurant> restaurants) {
        return restaurants.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}