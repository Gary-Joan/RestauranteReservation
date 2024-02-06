package com.garyortiz.org.restaurantReservation.application.controller;

import com.garyortiz.org.restaurantReservation.application.service.Restaurant.JpaRestaurantService;
import com.garyortiz.org.restaurantReservation.application.service.TableR.TableRGenericService;
import com.garyortiz.org.restaurantReservation.domain.dto.RestaurantDto;
import com.garyortiz.org.restaurantReservation.domain.dto.TableDto;
import com.garyortiz.org.restaurantReservation.domain.entity.jpa.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tables")
public class TableController {

    @Autowired
    private List<TableRGenericService<TableDto>> tableServices;

    private TableRGenericService<TableDto> getTableService() {
        return tableServices.get(0); // Adjust index accordingly
    }
    @Autowired
    private JpaRestaurantService restaurantService; // Suponiendo que tienes un servicio para gestionar los restaurantes

    @PostMapping
    public ResponseEntity<TableDto> createTable(@RequestBody TableDto tableDto) {
        try{
            RestaurantDto restaurantDTo = restaurantService.findById(tableDto.getRestaurantId());
            Restaurant restaurant= Restaurant.builder()
                    .id((Integer) restaurantDTo.getId())
                    .build();

            if (restaurant == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retornar 404 si el restaurante no existe
            }

            // Asignar el restaurante al objeto TableDto
            TableDto tableDto1= new TableDto();
            tableDto1.setRestaurantId(restaurant);

            // Llamar al servicio para crear la mesa
            getTableService().register(tableDto1);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (IllegalArgumentException ex){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<TableDto> getTableById(@PathVariable("id") Object id) {
        TableDto tableDto = getTableService().findById(id);
        return tableDto != null ?
                new ResponseEntity<>(tableDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<TableDto>> getAllTables() {
        List<TableDto> tables = getTableService().findAll();
        return new ResponseEntity<>(tables, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableDto> updateTable(@PathVariable("id") Object id, @RequestBody TableDto tableDto) {
        getTableService().update(id, tableDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable("id") Object id) {
        getTableService().remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
