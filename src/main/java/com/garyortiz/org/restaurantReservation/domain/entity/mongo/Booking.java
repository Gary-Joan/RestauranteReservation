package com.garyortiz.org.restaurantReservation.domain.entity.mongo;


import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection = "booking")
public class Booking {

    @Id
    private String id;

    private String restauranteId;
    private String mesaId;
    private String usuarioId;
    private LocalDateTime fechaHoraReserva;
    private String estado;

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurantId() {
        return restauranteId;
    }

    public void setRestaurantId(String restauranteId) {
        this.restauranteId = restauranteId;
    }

    public String getTableId() {
        return mesaId;
    }

    public void setTableId(String mesaId) {
        this.mesaId = mesaId;
    }

    public String getUserId() {
        return usuarioId;
    }

    public void setUserId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getBookingDateTime() {
        return fechaHoraReserva;
    }

    public void setBookingDateTime(LocalDateTime fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    public String getStatus() {
        return estado;
    }

    public void setStatus(String estado) {
        this.estado = estado;
    }
}
