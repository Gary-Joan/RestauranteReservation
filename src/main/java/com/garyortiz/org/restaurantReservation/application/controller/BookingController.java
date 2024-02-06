package com.garyortiz.org.restaurantReservation.application.controller;

import com.garyortiz.org.restaurantReservation.application.service.Booking.BookingGenericService;
import com.garyortiz.org.restaurantReservation.application.service.Restaurant.JpaRestaurantService;
import com.garyortiz.org.restaurantReservation.application.service.Restaurant.RestaurantGenericService;
import com.garyortiz.org.restaurantReservation.application.service.TableR.JpaTableRService;
import com.garyortiz.org.restaurantReservation.application.service.TableR.TableRGenericService;
import com.garyortiz.org.restaurantReservation.application.service.User.UserGenericService;
import com.garyortiz.org.restaurantReservation.domain.dto.BookingDto;
import com.garyortiz.org.restaurantReservation.domain.dto.RestaurantDto;
import com.garyortiz.org.restaurantReservation.domain.dto.TableDto;
import com.garyortiz.org.restaurantReservation.domain.dto.UserDto;
import com.garyortiz.org.restaurantReservation.domain.entity.jpa.Restaurant;
import com.garyortiz.org.restaurantReservation.domain.entity.jpa.TableR;
import com.garyortiz.org.restaurantReservation.domain.entity.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {
    int bd = 0;
    @Autowired
    private List<BookingGenericService<BookingDto>> bookingServices;

    // Lista de servicios genéricos de restaurante
    @Autowired
    private List<RestaurantGenericService<RestaurantDto>> restaurantServices;

    // Lista de servicios genéricos de mesa
    @Autowired
    private List<TableRGenericService<TableDto>> tableServices;
    @Autowired
    private List<UserGenericService<UserDto>> UserServices;

    private BookingGenericService<BookingDto> getBookingService() {
        return bookingServices.get(bd); // Adjust index accordingly
    }
    private RestaurantGenericService<RestaurantDto> getRestaurantService() {
        return restaurantServices.get(bd); // Adjust index accordingly
    }
    private TableRGenericService<TableDto> getTableService() {
        return tableServices.get(bd); // Adjust index accordingly
    }
    private UserGenericService<UserDto> getUserService() {
        return UserServices.get(bd); // Adjust index accordingly
    }
    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        try {
            // Verificar si el restaurante existe
            RestaurantDto restaurantDto = getRestaurantService().findById(bookingDto.getRestaurantId());
            Restaurant restaurant = Restaurant.builder()
                    .id((Integer) restaurantDto.getId()).build();
            if (restaurant == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retornar 404 si el restaurante no existe
            }

            // Verificar si la mesa existe
            TableDto tableDto = getTableService().findById(bookingDto.getTableId());
            TableR tableR= TableR.builder()
                    .id((Integer) tableDto.getId()).build();
            if (tableR == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retornar 404 si la mesa no existe
            }

            // Verificar si el usuario existe
            UserDto userDto = getUserService().findById(bookingDto.getUserId());
            User user = User.builder()
                    .id((Integer) userDto.getId()).build();
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retornar 404 si el usuario no existe
            }

            // Crear el objeto de reserva (booking) con las transformaciones necesarias
            BookingDto bookingDtoToCreate = new BookingDto();
            bookingDtoToCreate.setRestaurantId(restaurant);
            bookingDtoToCreate.setTableId(tableR);
            bookingDtoToCreate.setUserId(user);
            bookingDtoToCreate.setBookingDateTime(bookingDto.getBookingDateTime());
            bookingDtoToCreate.setStatus(bookingDto.getStatus());

            // Llamar al servicio para crear la reserva
            getBookingService().register(bookingDtoToCreate);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable("id") Object id) {
        BookingDto bookingDto = getBookingService().findById(id);
        return bookingDto != null ?
                new ResponseEntity<>(bookingDto, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        List<BookingDto> bookings = getBookingService().findAll();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> updateBooking(@PathVariable("id") Object id, @RequestBody BookingDto bookingDto) {
        getBookingService().update(id, bookingDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") Object id) {
        getBookingService().remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
