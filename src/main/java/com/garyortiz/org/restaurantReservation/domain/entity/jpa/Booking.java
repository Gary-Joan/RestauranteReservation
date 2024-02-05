package com.garyortiz.org.restaurantReservation.domain.entity.jpa;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurante;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "table_id")
    private TableR mesa;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User usuario;

    private LocalDateTime fechaHoraReserva;
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Restaurant getRestaurantId() {
        return restaurante;
    }

    public void setRestaurantId(Restaurant restaurante) {
        this.restaurante = restaurante;
    }

    public TableR getTableId() {
        return mesa;
    }

    public void setTableId(TableR mesa) {
        this.mesa = mesa;
    }

    public User getUserId() {
        return usuario;
    }

    public void setUserId(User usuario) {
        this.usuario = usuario;
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
