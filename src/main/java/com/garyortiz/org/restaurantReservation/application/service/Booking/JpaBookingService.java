package com.garyortiz.org.restaurantReservation.application.service.Booking;

import com.garyortiz.org.restaurantReservation.domain.dto.BookingDto;
import com.garyortiz.org.restaurantReservation.domain.entity.jpa.Booking;

import com.garyortiz.org.restaurantReservation.domain.entity.jpa.Restaurant;
import com.garyortiz.org.restaurantReservation.domain.entity.jpa.TableR;
import com.garyortiz.org.restaurantReservation.domain.entity.jpa.User;
import com.garyortiz.org.restaurantReservation.domain.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JpaBookingService implements BookingGenericService<BookingDto> {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public String register(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setRestaurantId((Restaurant) bookingDto.getRestaurantId());
        booking.setTableId((TableR) bookingDto.getTableId());
        booking.setUserId((User) bookingDto.getUserId());
        booking.setBookingDateTime(bookingDto.getBookingDateTime());
        booking.setStatus(bookingDto.getStatus());

        bookingRepository.save(booking);
        return "";
    }

    @Override
    public void update(Object id, BookingDto bookingDto) {
        Booking booking = bookingRepository.findById((Integer) id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        // Solo actualiza los campos que pueden cambiar
        booking.setTableId((TableR) bookingDto.getTableId());
        booking.setUserId((User) bookingDto.getUserId());
        booking.setBookingDateTime(bookingDto.getBookingDateTime());
        booking.setStatus(bookingDto.getStatus());

        bookingRepository.save(booking);
    }

    @Override
    public BookingDto findById(Object id) {
        Booking booking = bookingRepository.findById((Integer) id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        return convertToDto(booking);
    }

    @Override
    public List<BookingDto> findAll() {
        List<Booking> bookings = bookingRepository.findAll();
        return convertToDtoList(bookings);
    }

    @Override
    public void remove(Object id) {
        bookingRepository.deleteById((Integer) id);
    }

    private BookingDto convertToDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setRestaurantId(booking.getRestaurantId());
        bookingDto.setTableId(booking.getTableId());
        bookingDto.setUserId(booking.getUserId());
        bookingDto.setBookingDateTime(booking.getBookingDateTime());
        bookingDto.setStatus(booking.getStatus());

        return bookingDto;
    }

    private List<BookingDto> convertToDtoList(List<Booking> bookings) {
        return bookings.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}