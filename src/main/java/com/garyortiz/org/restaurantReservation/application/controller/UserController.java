package com.garyortiz.org.restaurantReservation.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.garyortiz.org.restaurantReservation.application.service.User.UserGenericService;
import com.garyortiz.org.restaurantReservation.domain.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    // Inyectar la lista de todos los beans que implementan UserGenericService
    @Autowired
    private List<UserGenericService<UserDto>> userServices;

    // Método para obtener un servicio de usuario específico
    private UserGenericService<UserDto> getUserService() {
        return userServices.get(0);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        getUserService().register(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Object id) {
        UserDto userDto = getUserService().findById(id);
        return userDto != null ?
                new ResponseEntity<>(userDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = getUserService().findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Object id, @RequestBody UserDto userDto) {
        getUserService().update(id, userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Object id) {
        getUserService().remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}