package com.garyortiz.org.restaurantReservation.application.service.Booking;

import com.garyortiz.org.restaurantReservation.domain.dto.BookingDto;

import java.util.List;

public class MongoBookingService implements BookingGenericService<BookingDto> {
    @Override
    public void register(BookingDto bookingDto) {

    }

    @Override
    public void update(Object id, BookingDto bookingDto) {

    }

    @Override
    public BookingDto findById(Object id) {
        return null;
    }

    @Override
    public List<BookingDto> findAll() {
        return null;
    }

    @Override
    public void remove(Object id) {

    }
}
