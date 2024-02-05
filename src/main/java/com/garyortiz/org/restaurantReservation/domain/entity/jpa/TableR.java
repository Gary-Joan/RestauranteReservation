package com.garyortiz.org.restaurantReservation.domain.entity.jpa;

import jakarta.persistence.*;

@Entity
public class TableR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurante;

    private int capacidad;
    private String estado;

    // Getters y setters
}
