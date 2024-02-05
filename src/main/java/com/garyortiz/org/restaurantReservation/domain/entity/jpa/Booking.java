package com.garyortiz.org.restaurantReservation.domain.entity.jpa;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurante;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private TableR mesa;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User usuario;

    private LocalDateTime fechaHoraReserva;
    private String estado;
}
