package com.garyortiz.org.restaurantReservation.domain.entity.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correoElectronico;
    private String contraseña;
    private String rol;

    public void setName(String name) {
        this.nombre = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.nombre;
    }
}
