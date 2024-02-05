package com.garyortiz.org.restaurantReservation.domain.dto;

import java.time.LocalDateTime;

public class BookingDto {
    private Object id;
    private Object restaurantId;
    private Object tableId;
    private Object userId;
    private LocalDateTime bookingDateTime;
    private String status;

    public Object getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Object getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}